package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.k.e.b;
import com.tencent.mm.plugin.appbrand.openmaterial.i.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.webview.WebViewTransHelper;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.m;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.d;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.f.g;
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
import org.json.JSONObject;

public final class o
  extends a
{
  com.tencent.mm.plugin.appbrand.openmaterial.i WVA;
  private b WVB;
  protected Map<String, SparseBooleanArray> WVh;
  protected Map<String, Integer> WVi;
  LruCache<String, Bitmap> WVj;
  HashMap<String, String> WVk;
  com.tencent.mm.plugin.webview.ui.tools.browser.f WVl;
  public HashMap<Integer, c> WVm;
  public q WVn;
  public String WVo;
  HashMap<String, Integer> WVp;
  boolean WVq;
  public boolean WVr;
  public boolean WVs;
  Set<Integer> WVt;
  private Set<Integer> WVu;
  com.tencent.mm.ui.base.s WVv;
  ArrayList<e.b> WVw;
  Boolean WVx;
  String WVy;
  AppBrandOpenMaterialCollection WVz;
  private int height;
  private String sCd;
  View tss;
  com.tencent.mm.ui.widget.a.f ucS;
  private int width;
  
  public o(WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
    AppMethodBeat.i(79877);
    this.WVh = new HashMap();
    this.WVi = new HashMap();
    this.WVj = new LruCache(12);
    this.WVk = new HashMap();
    this.WVl = new com.tencent.mm.plugin.webview.ui.tools.browser.f(1);
    this.WVm = new HashMap();
    this.WVn = new q();
    this.tss = null;
    this.sCd = "";
    this.WVp = new HashMap();
    this.WVq = false;
    this.WVr = true;
    this.WVs = false;
    this.WVt = new HashSet();
    this.WVu = new HashSet() {};
    this.WVy = null;
    this.WVz = null;
    this.WVA = null;
    this.WVB = null;
    this.width = paramWebViewUI.getResources().getDisplayMetrics().widthPixels;
    this.height = paramWebViewUI.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(79877);
  }
  
  static ResolveInfo a(WebViewUI paramWebViewUI, com.tencent.mm.plugin.webview.stub.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(296147);
    if (parame != null) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("WebViewShare_wv_url", paramWebViewUI.fqa());
        localBundle = parame.m(120000, localBundle);
        parame = localBundle.getString("default_browser_package_name", "");
        paramWebViewUI = com.tencent.mm.plugin.webview.ui.tools.browser.b.Z(paramWebViewUI, parame, localBundle.getString("k_share_url", ""));
        if (paramWebViewUI != null) {}
        for (;;)
        {
          Log.i("MicroMsg.WebViewMenuHelper", "alvinluo getDefaultBrowser defaultBrowserPackageName: %s, defaultBrowser != null: %b", new Object[] { parame, Boolean.valueOf(bool) });
          AppMethodBeat.o(296147);
          return paramWebViewUI;
          bool = false;
        }
        AppMethodBeat.o(296147);
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
    paramInt = paramJsapiPermissionWrapper.axr(paramInt);
    if ((paramInt == 1) || (paramInt == 10))
    {
      AppMethodBeat.o(79882);
      return true;
    }
    AppMethodBeat.o(79882);
    return false;
  }
  
  static boolean a(com.tencent.mm.ui.base.s params, int paramInt, Drawable paramDrawable, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(296151);
    if (params == null)
    {
      AppMethodBeat.o(296151);
      return false;
    }
    if (params.findItem(45) != null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem has added and ignore");
      AppMethodBeat.o(296151);
      return false;
    }
    Log.d("MicroMsg.WebViewMenuHelper", "alvinluo doAddDefaultBrowserMenuItem index: %s", new Object[] { Integer.valueOf(paramInt) });
    params = params.a(45, paramInt, paramString, 0, paramBoolean);
    if ((params instanceof t))
    {
      ((t)params).adRY = TextUtils.TruncateAt.END;
      ((t)params).adSa = false;
    }
    params.setIcon(paramDrawable);
    AppMethodBeat.o(296151);
    return true;
  }
  
  private void aus(int paramInt)
  {
    AppMethodBeat.i(79891);
    String str2 = iwO().bjg(iwO().Wzl.Www);
    if ((TextUtils.isEmpty(iwO().Wzl.Www)) || (TextUtils.isEmpty(str2)))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "stev appId is null or empty");
      AppMethodBeat.o(79891);
      return;
    }
    Log.i("MicroMsg.WebViewMenuHelper", "stev appId %s", new Object[] { str2 });
    long l = Util.nowSecond();
    Log.d("MicroMsg.WebViewMenuHelper", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13377), Long.valueOf(l), str2, iwO().Wzl.Www, iwO().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt) });
    Object localObject = "";
    try
    {
      str1 = r.as(iwO().Wzl.Www, "UTF-8");
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
    i = iwO().avS(iwO().getIntent().getStringExtra("geta8key_username"));
    str1 = "";
    if ((i == 7) || (i == 56)) {
      str1 = iwO().getIntent().getStringExtra("geta8key_username");
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(13377, new Object[] { Long.valueOf(l), str2, localObject, iwO().sessionId, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(0), str1 });
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
    if (paramJsapiPermissionWrapper.axr(paramInt) == 10)
    {
      AppMethodBeat.o(79883);
      return true;
    }
    AppMethodBeat.o(79883);
    return false;
  }
  
  private boolean ixM()
  {
    AppMethodBeat.i(296132);
    try
    {
      JsapiPermissionWrapper localJsapiPermissionWrapper = iwO().iwo();
      if ((!this.WVq) && (iwO().iyR() != 16) && (aur(7)) && (a(localJsapiPermissionWrapper, 45)) && (auq(7)) && (!b(localJsapiPermissionWrapper, 45)) && (!this.WVx.booleanValue()))
      {
        AppMethodBeat.o(296132);
        return true;
      }
      AppMethodBeat.o(296132);
      return false;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "canShowOpenMaterials fail since ".concat(String.valueOf(localException)));
      AppMethodBeat.o(296132);
    }
    return false;
  }
  
  private ArrayList<e.b> ixT()
  {
    AppMethodBeat.i(79888);
    if (iwO().sMP == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "getCustomMenuList viewWV is null");
      AppMethodBeat.o(79888);
      return null;
    }
    Object localObject = iwO().sMP.getUrl();
    if (iwO().WXM.containsKey(localObject))
    {
      localObject = (ArrayList)iwO().WXM.get(localObject);
      AppMethodBeat.o(79888);
      return localObject;
    }
    AppMethodBeat.o(79888);
    return null;
  }
  
  final void IM(final boolean paramBoolean)
  {
    AppMethodBeat.i(296219);
    Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, onBottomSheetCreate: ".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.appbrand.service.j localj = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.j.class);
    if (localj == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is null");
      AppMethodBeat.o(296219);
      return;
    }
    if (!localj.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trW))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is disabled");
      AppMethodBeat.o(296219);
      return;
    }
    Object localObject = iwO();
    if (localObject == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, webViewUI is null");
      AppMethodBeat.o(296219);
      return;
    }
    localObject = ((WebViewUI)localObject).Wzl;
    if (localObject == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, controller is null");
      AppMethodBeat.o(296219);
      return;
    }
    localObject = ((com.tencent.mm.plugin.webview.core.k)localObject).bLY();
    Log.d("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url: ".concat(String.valueOf(localObject)));
    if (Util.isNullOrNil((String)localObject))
    {
      Log.w("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, url is empty");
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(296236);
          o.this.IM(paramBoolean);
          AppMethodBeat.o(296236);
        }
      }, 1000L);
      AppMethodBeat.o(296219);
      return;
    }
    if ((paramBoolean) && (this.WVA != null))
    {
      this.WVA.dead();
      this.WVA = null;
    }
    if (((String)localObject).equals(this.WVy))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, already load");
      a(localj);
      AppMethodBeat.o(296219);
      return;
    }
    MaterialModel localMaterialModel = MaterialModel.aer((String)localObject);
    if (!localj.aen(localMaterialModel.mimeType))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "loadOpenMaterialsIfNeedAndEnhanceBottomSheet, openMaterialService is not support " + localMaterialModel.mimeType);
      AppMethodBeat.o(296219);
      return;
    }
    localj.a(localMaterialModel, new a(this, (String)localObject, localj));
    AppMethodBeat.o(296219);
  }
  
  protected final void a(final long paramLong, final ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, final int paramInt)
  {
    AppMethodBeat.i(296320);
    if (bpe())
    {
      Log.w("MicroMsg.WebViewMenuHelper", "showReaderModeMenu, webViewUI is finished");
      AppMethodBeat.o(296320);
      return;
    }
    Log.i("MicroMsg.WebViewMenuHelper", "showReaderModeMenu  mpShowMenuItems:%d , imersiveMode:%b, isDarkStyle:%b, disableMenuHeader:%b, itemShowType:%d", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(this.WVq), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
    this.WVw = ixT();
    boolean bool;
    if ((this.WVw != null) && (this.WVw.size() > 0))
    {
      bool = true;
      this.WVx = Boolean.valueOf(bool);
      bool = ixP();
      if (!bool)
      {
        if (!this.WVx.booleanValue()) {
          break label354;
        }
        this.ucS = new com.tencent.mm.ui.widget.a.f(iwO(), 1, false);
      }
      label161:
      if ((this.WVq) || (paramBoolean1)) {
        this.ucS.NE(true);
      }
      if (bool) {
        break label374;
      }
    }
    Object localObject2;
    label354:
    label374:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      IM(paramBoolean1);
      this.WVn.WWo = System.currentTimeMillis();
      this.ucS.ages = new f.a()
      {
        public final void onClick()
        {
          o.this.WVn.lsO = 1;
        }
      };
      this.ucS.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          AppMethodBeat.i(296423);
          o.this.WVn.WWp = System.currentTimeMillis();
          paramAnonymousView = o.this.WVn;
          AppCompatActivity localAppCompatActivity = o.this.iwO().getContext();
          kotlin.g.b.s.u(localAppCompatActivity, "context");
          if (paramAnonymousView.WWp <= paramAnonymousView.WWo)
          {
            Log.i("MicroMsg.WebViewRecentForwardReporter", "bottomSheetDismissTiming <= zeroMenuAppearTiming");
            AppMethodBeat.o(296423);
            return;
          }
          Object localObject = q.kU(localAppCompatActivity);
          if (localObject == null)
          {
            Log.w("MicroMsg.WebViewRecentForwardReporter", "tryReport, recentForwardReportInfo is null");
            AppMethodBeat.o(296423);
            return;
          }
          if (paramAnonymousView.WWn) {}
          for (int i = 3;; i = 2)
          {
            ((emx)localObject).scene = i;
            ((emx)localObject).MFq = "49";
            ((emx)localObject).abrg = "5";
            ((emx)localObject).toUser = paramAnonymousView.toUser;
            ((emx)localObject).lsO = paramAnonymousView.lsO;
            ((emx)localObject).Qmp = ((int)(paramAnonymousView.WWp - paramAnonymousView.WWo));
            if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
              Log.d("MicroMsg.WebViewRecentForwardReporter", kotlin.g.b.s.X("tryReport, recentForwardReportInfo: ", q.a((emx)localObject)));
            }
            localObject = com.tencent.mm.pluginsdk.j.a.XUW;
            com.tencent.mm.pluginsdk.j.a.ly(localAppCompatActivity);
            paramAnonymousView.toUser = "";
            paramAnonymousView.lsO = 1;
            paramAnonymousView.WWn = false;
            paramAnonymousView.WWo = 0L;
            paramAnonymousView.WWp = 0L;
            AppMethodBeat.o(296423);
            return;
          }
        }
      });
      this.ucS.Vti = new u.b()
      {
        public final void onAttach(ImageView paramAnonymousImageView1, ImageView paramAnonymousImageView2, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(296430);
          String str = paramAnonymousMenuItem.getTitle();
          if (!Util.isNullOrNil(((t)paramAnonymousMenuItem).rDm)) {
            try
            {
              paramAnonymousMenuItem = f.blB(o.this.iwO().Wzl.sLC.blm(((t)paramAnonymousMenuItem).rDm));
              paramAnonymousMenuItem = BitmapUtil.getRoundedCornerBitmap(paramAnonymousMenuItem, true, 0.1F * paramAnonymousMenuItem.getWidth());
              paramAnonymousImageView1.setVisibility(8);
              paramAnonymousImageView2.setImageBitmap(paramAnonymousMenuItem);
              paramAnonymousImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
              o.this.WVj.put(str, paramAnonymousMenuItem);
              AppMethodBeat.o(296430);
              return;
            }
            catch (RemoteException paramAnonymousImageView1)
            {
              Log.w("MicroMsg.WebViewMenuHelper", "handle share to recent friends, ex = " + paramAnonymousImageView1.getMessage());
              AppMethodBeat.o(296430);
              return;
            }
          }
          if (o.h(paramAnonymousMenuItem))
          {
            paramAnonymousImageView1.setVisibility(8);
            AppMethodBeat.o(296430);
            return;
          }
          if ((o.this.WVj.get(str) != null) && (!((Bitmap)o.this.WVj.get(str)).isRecycled()))
          {
            paramAnonymousImageView1.setImageBitmap((Bitmap)o.this.WVj.get(str));
            AppMethodBeat.o(296430);
            return;
          }
          Log.w("MicroMsg.WebViewMenuHelper", "on attach icon, load from cache fail");
          try
          {
            paramAnonymousImageView2 = o.this.iwO().Wzl.sLC.blm(str);
            if (!Util.isNullOrNil(paramAnonymousImageView2))
            {
              paramAnonymousImageView2 = f.blB(paramAnonymousImageView2);
              if ((paramAnonymousImageView2 != null) && (!paramAnonymousImageView2.isRecycled()))
              {
                paramAnonymousImageView1.setImageBitmap(paramAnonymousImageView2);
                o.this.WVj.put(str, paramAnonymousImageView2);
              }
            }
            AppMethodBeat.o(296430);
            return;
          }
          catch (Exception paramAnonymousImageView1)
          {
            Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramAnonymousImageView1.getMessage());
            AppMethodBeat.o(296430);
          }
        }
      };
      this.ucS.Vtj = new u.d()
      {
        public final void onAttach(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(296442);
          String str = paramAnonymousMenuItem.getTitle();
          if (paramAnonymousTextView != null)
          {
            if (((paramAnonymousMenuItem instanceof t)) && (((t)paramAnonymousMenuItem).nickName != null))
            {
              paramAnonymousTextView.setText(((t)paramAnonymousMenuItem).nickName.toString());
              AppMethodBeat.o(296442);
              return;
            }
            paramAnonymousMenuItem = (String)o.this.WVk.get(str);
            if (Util.isNullOrNil(paramAnonymousMenuItem))
            {
              paramAnonymousTextView.setText(str);
              AppMethodBeat.o(296442);
              return;
            }
            paramAnonymousTextView.setText(p.b(o.this.iwO(), paramAnonymousMenuItem, paramAnonymousTextView.getTextSize()));
          }
          AppMethodBeat.o(296442);
        }
      };
      localObject2 = new u.i()
      {
        /* Error */
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          // Byte code:
          //   0: ldc 34
          //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   9: invokevirtual 44	com/tencent/mm/plugin/webview/ui/tools/o:bpe	()Z
          //   12: ifeq +9 -> 21
          //   15: ldc 34
          //   17: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   20: return
          //   21: aload_1
          //   22: invokestatic 51	com/tencent/mm/plugin/webview/ui/tools/o:h	(Landroid/view/MenuItem;)Z
          //   25: ifeq +145 -> 170
          //   28: aload_1
          //   29: invokeinterface 57 1 0
          //   34: checkcast 59	com/tencent/mm/k/e$b
          //   37: astore 5
          //   39: aload 5
          //   41: ifnull +123 -> 164
          //   44: aload_0
          //   45: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   48: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   51: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   54: astore_1
          //   55: aload_1
          //   56: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   59: ifne +16 -> 75
          //   62: ldc 77
          //   64: ldc 79
          //   66: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   69: ldc 34
          //   71: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   74: return
          //   75: ldc 77
          //   77: ldc 87
          //   79: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   82: new 91	java/util/HashMap
          //   85: dup
          //   86: invokespecial 92	java/util/HashMap:<init>	()V
          //   89: astore 6
          //   91: aload 6
          //   93: ldc 94
          //   95: aload 5
          //   97: getfield 97	com/tencent/mm/k/e$b:key	Ljava/lang/String;
          //   100: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   103: pop
          //   104: aload 6
          //   106: ldc 103
          //   108: aload 5
          //   110: getfield 105	com/tencent/mm/k/e$b:title	Ljava/lang/String;
          //   113: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   116: pop
          //   117: ldc 107
          //   119: aload 6
          //   121: aload_1
          //   122: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   125: aload_1
          //   126: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   129: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   132: astore 5
          //   134: aload_1
          //   135: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   138: new 125	java/lang/StringBuilder
          //   141: dup
          //   142: ldc 127
          //   144: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   147: aload 5
          //   149: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   152: ldc 136
          //   154: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   157: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   160: aconst_null
          //   161: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   164: ldc 34
          //   166: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   169: return
          //   170: aload_1
          //   171: invokeinterface 150 1 0
          //   176: iconst_1
          //   177: if_icmpne +527 -> 704
          //   180: aload_0
          //   181: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   184: getfield 154	com/tencent/mm/plugin/webview/ui/tools/o:WVn	Lcom/tencent/mm/plugin/webview/ui/tools/q;
          //   187: iconst_2
          //   188: putfield 160	com/tencent/mm/plugin/webview/ui/tools/q:lsO	I
          //   191: ldc 162
          //   193: ldc 164
          //   195: iconst_1
          //   196: anewarray 4	java/lang/Object
          //   199: dup
          //   200: iconst_0
          //   201: aload_1
          //   202: invokeinterface 150 1 0
          //   207: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   210: aastore
          //   211: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   214: aload_1
          //   215: invokeinterface 150 1 0
          //   220: tableswitch	default:+412 -> 632, 1:+578->798, 2:+809->1029, 3:+1127->1347, 4:+412->632, 5:+1240->1460, 6:+1650->1870, 7:+1713->1933, 8:+2697->2917, 9:+2855->3075, 10:+2955->3175, 11:+1374->1594, 12:+3020->3240, 13:+412->632, 14:+412->632, 15:+3151->3371, 16:+3216->3436, 17:+3281->3501, 18:+3346->3566, 19:+3411->3631, 20:+3781->4001, 21:+3978->4198, 22:+4136->4356, 23:+710->930, 24:+4542->4762, 25:+3476->3696, 26:+3717->3937, 27:+498->718, 28:+1552->1772, 29:+4824->5044, 30:+412->632, 31:+4888->5108, 32:+412->632, 33:+4333->4553, 34:+5012->5232, 35:+5110->5330, 36:+5211->5431, 37:+2684->2904, 38:+997->1217, 39:+1062->1282, 40:+5367->5587, 41:+5367->5587, 42:+5367->5587, 43:+3476->3696, 44:+5397->5617, 45:+2279->2499, 46:+1204->1424, 47:+412->632, 48:+412->632, 49:+412->632, 50:+412->632, 51:+412->632, 52:+412->632, 53:+412->632, 54:+412->632, 55:+412->632, 56:+412->632, 57:+412->632, 58:+412->632, 59:+412->632, 60:+412->632, 61:+412->632, 62:+412->632, 63:+412->632, 64:+412->632, 65:+412->632, 66:+412->632, 67:+412->632, 68:+412->632, 69:+412->632, 70:+412->632, 71:+412->632, 72:+412->632, 73:+412->632, 74:+412->632, 75:+412->632, 76:+412->632, 77:+412->632, 78:+412->632, 79:+412->632, 80:+412->632, 81:+412->632, 82:+412->632, 83:+412->632, 84:+412->632, 85:+412->632, 86:+412->632, 87:+412->632, 88:+412->632, 89:+412->632, 90:+412->632, 91:+412->632, 92:+412->632, 93:+412->632, 94:+412->632, 95:+412->632, 96:+412->632, 97:+412->632, 98:+412->632, 99:+5268->5488
          //   633: getfield 23	com/tencent/mm/plugin/webview/ui/tools/o$2:WVE	Ljava/util/ArrayList;
          //   636: invokevirtual 178	java/util/ArrayList:isEmpty	()Z
          //   639: ifne +5173 -> 5812
          //   642: iconst_0
          //   643: istore_3
          //   644: iload_3
          //   645: aload_0
          //   646: getfield 23	com/tencent/mm/plugin/webview/ui/tools/o$2:WVE	Ljava/util/ArrayList;
          //   649: invokevirtual 181	java/util/ArrayList:size	()I
          //   652: if_icmpge +5160 -> 5812
          //   655: iload_2
          //   656: iload_3
          //   657: if_icmpne +5148 -> 5805
          //   660: aload_0
          //   661: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   664: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   667: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   670: astore_1
          //   671: aload_0
          //   672: getfield 23	com/tencent/mm/plugin/webview/ui/tools/o$2:WVE	Ljava/util/ArrayList;
          //   675: iload_3
          //   676: invokevirtual 185	java/util/ArrayList:get	(I)Ljava/lang/Object;
          //   679: checkcast 187	java/lang/String
          //   682: astore 5
          //   684: aload_1
          //   685: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   688: ifne +4949 -> 5637
          //   691: ldc 77
          //   693: ldc 189
          //   695: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   698: ldc 34
          //   700: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   703: return
          //   704: aload_0
          //   705: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   708: getfield 154	com/tencent/mm/plugin/webview/ui/tools/o:WVn	Lcom/tencent/mm/plugin/webview/ui/tools/q;
          //   711: iconst_4
          //   712: putfield 160	com/tencent/mm/plugin/webview/ui/tools/q:lsO	I
          //   715: goto -524 -> 191
          //   718: aload_0
          //   719: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   722: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   725: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   728: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   731: iconst_3
          //   732: anewarray 4	java/lang/Object
          //   735: dup
          //   736: iconst_0
          //   737: aload_0
          //   738: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   741: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   744: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   747: aastore
          //   748: dup
          //   749: iconst_1
          //   750: bipush 32
          //   752: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   755: aastore
          //   756: dup
          //   757: iconst_2
          //   758: iconst_1
          //   759: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   762: aastore
          //   763: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   766: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   769: aload_0
          //   770: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   773: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   776: invokevirtual 214	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:iue	()Z
          //   779: ifne +5422 -> 6201
          //   782: aload_0
          //   783: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   786: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   789: invokevirtual 217	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:finish	()V
          //   792: ldc 34
          //   794: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   797: return
          //   798: aload_0
          //   799: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   802: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   805: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   808: ldc 226
          //   810: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   813: astore_1
          //   814: aload_0
          //   815: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   818: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   821: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   824: ldc 234
          //   826: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   829: astore 5
          //   831: aload_0
          //   832: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   835: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   838: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   841: ldc 236
          //   843: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   846: astore 6
          //   848: aload_0
          //   849: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   852: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   855: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   858: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   861: bipush 6
          //   863: anewarray 4	java/lang/Object
          //   866: dup
          //   867: iconst_0
          //   868: aload_0
          //   869: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   872: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   875: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   878: aastore
          //   879: dup
          //   880: iconst_1
          //   881: iconst_1
          //   882: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   885: aastore
          //   886: dup
          //   887: iconst_2
          //   888: iconst_1
          //   889: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   892: aastore
          //   893: dup
          //   894: iconst_3
          //   895: aload_1
          //   896: aastore
          //   897: dup
          //   898: iconst_4
          //   899: aload 5
          //   901: aastore
          //   902: dup
          //   903: iconst_5
          //   904: aload 6
          //   906: aastore
          //   907: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   910: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   913: aload_0
          //   914: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   917: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   920: iconst_0
          //   921: invokevirtual 239	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:auy	(I)V
          //   924: ldc 34
          //   926: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   929: return
          //   930: new 228	android/content/Intent
          //   933: dup
          //   934: invokespecial 240	android/content/Intent:<init>	()V
          //   937: astore_1
          //   938: aload_0
          //   939: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   942: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   945: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   948: ldc 242
          //   950: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   953: astore 5
          //   955: aload 5
          //   957: ifnull +39 -> 996
          //   960: aload_1
          //   961: ldc 244
          //   963: iconst_1
          //   964: invokevirtual 248	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   967: pop
          //   968: aload_1
          //   969: ldc 242
          //   971: aload 5
          //   973: invokevirtual 251	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   976: pop
          //   977: aload_0
          //   978: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   981: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   984: ldc 253
          //   986: aload_1
          //   987: invokestatic 259	com/tencent/mm/br/c:g	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   990: ldc 34
          //   992: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   995: return
          //   996: aload_1
          //   997: ldc_w 261
          //   1000: aload_0
          //   1001: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1004: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1007: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1010: ldc_w 263
          //   1013: ldc2_w 264
          //   1016: invokevirtual 269	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   1019: invokestatic 274	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1022: invokevirtual 277	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
          //   1025: pop
          //   1026: goto -49 -> 977
          //   1029: aload_0
          //   1030: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1033: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1036: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1039: ldc 226
          //   1041: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1044: astore_1
          //   1045: aload_0
          //   1046: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1049: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1052: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1055: ldc 234
          //   1057: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1060: astore 5
          //   1062: aload_0
          //   1063: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1066: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1069: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1072: ldc 236
          //   1074: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1077: astore 6
          //   1079: aload_0
          //   1080: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1083: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1086: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1089: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1092: bipush 6
          //   1094: anewarray 4	java/lang/Object
          //   1097: dup
          //   1098: iconst_0
          //   1099: aload_0
          //   1100: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1103: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1106: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1109: aastore
          //   1110: dup
          //   1111: iconst_1
          //   1112: iconst_2
          //   1113: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1116: aastore
          //   1117: dup
          //   1118: iconst_2
          //   1119: iconst_1
          //   1120: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1123: aastore
          //   1124: dup
          //   1125: iconst_3
          //   1126: aload_1
          //   1127: aastore
          //   1128: dup
          //   1129: iconst_4
          //   1130: aload 5
          //   1132: aastore
          //   1133: dup
          //   1134: iconst_5
          //   1135: aload 6
          //   1137: aastore
          //   1138: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1141: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1144: iconst_0
          //   1145: istore_2
          //   1146: aload_0
          //   1147: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1150: getfield 281	com/tencent/mm/plugin/webview/ui/tools/o:WVp	Ljava/util/HashMap;
          //   1153: aload_0
          //   1154: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1157: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1160: getfield 284	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1163: invokevirtual 287	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1166: invokevirtual 291	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
          //   1169: ifeq +33 -> 1202
          //   1172: aload_0
          //   1173: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1176: getfield 281	com/tencent/mm/plugin/webview/ui/tools/o:WVp	Ljava/util/HashMap;
          //   1179: aload_0
          //   1180: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1183: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1186: getfield 284	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1189: invokevirtual 287	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1192: invokevirtual 294	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1195: checkcast 166	java/lang/Integer
          //   1198: invokevirtual 297	java/lang/Integer:intValue	()I
          //   1201: istore_2
          //   1202: aload_0
          //   1203: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1206: iload_2
          //   1207: iconst_0
          //   1208: invokestatic 300	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;II)V
          //   1211: ldc 34
          //   1213: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1216: return
          //   1217: aload_0
          //   1218: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1221: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1224: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1227: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1230: iconst_3
          //   1231: anewarray 4	java/lang/Object
          //   1234: dup
          //   1235: iconst_0
          //   1236: aload_0
          //   1237: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1240: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1243: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1246: aastore
          //   1247: dup
          //   1248: iconst_1
          //   1249: bipush 36
          //   1251: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1254: aastore
          //   1255: dup
          //   1256: iconst_2
          //   1257: iconst_1
          //   1258: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1261: aastore
          //   1262: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1265: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1268: aload_0
          //   1269: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1272: iconst_1
          //   1273: invokestatic 303	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;I)V
          //   1276: ldc 34
          //   1278: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1281: return
          //   1282: aload_0
          //   1283: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1286: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1289: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1292: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1295: iconst_3
          //   1296: anewarray 4	java/lang/Object
          //   1299: dup
          //   1300: iconst_0
          //   1301: aload_0
          //   1302: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1305: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1308: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1311: aastore
          //   1312: dup
          //   1313: iconst_1
          //   1314: bipush 37
          //   1316: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1319: aastore
          //   1320: dup
          //   1321: iconst_2
          //   1322: iconst_1
          //   1323: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1326: aastore
          //   1327: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1330: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1333: aload_0
          //   1334: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1337: iconst_0
          //   1338: invokestatic 303	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;I)V
          //   1341: ldc 34
          //   1343: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1346: return
          //   1347: aload_0
          //   1348: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1351: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1354: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1357: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1360: iconst_3
          //   1361: anewarray 4	java/lang/Object
          //   1364: dup
          //   1365: iconst_0
          //   1366: aload_0
          //   1367: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1370: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1373: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1376: aastore
          //   1377: dup
          //   1378: iconst_1
          //   1379: iconst_3
          //   1380: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1383: aastore
          //   1384: dup
          //   1385: iconst_2
          //   1386: iconst_1
          //   1387: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1390: aastore
          //   1391: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1394: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1397: getstatic 309	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
          //   1400: ldc2_w 310
          //   1403: ldc2_w 312
          //   1406: lconst_1
          //   1407: iconst_0
          //   1408: invokevirtual 317	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1411: aload_0
          //   1412: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1415: invokevirtual 320	com/tencent/mm/plugin/webview/ui/tools/o:ixU	()V
          //   1418: ldc 34
          //   1420: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1423: return
          //   1424: aload_0
          //   1425: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1428: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1431: invokevirtual 324	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:iyi	()Lcom/tencent/mm/plugin/handoff/model/HandOffURL;
          //   1434: astore_1
          //   1435: aload_1
          //   1436: ifnull +4765 -> 6201
          //   1439: ldc_w 326
          //   1442: invokestatic 332	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
          //   1445: checkcast 326	com/tencent/mm/plugin/handoff/a/a
          //   1448: aload_1
          //   1449: invokeinterface 336 2 0
          //   1454: ldc 34
          //   1456: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1459: return
          //   1460: aload_0
          //   1461: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1464: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1467: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1470: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1473: iconst_3
          //   1474: anewarray 4	java/lang/Object
          //   1477: dup
          //   1478: iconst_0
          //   1479: aload_0
          //   1480: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1483: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1486: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1489: aastore
          //   1490: dup
          //   1491: iconst_1
          //   1492: iconst_4
          //   1493: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1496: aastore
          //   1497: dup
          //   1498: iconst_2
          //   1499: iconst_1
          //   1500: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1503: aastore
          //   1504: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1507: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1510: aload_0
          //   1511: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1514: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1517: getfield 339	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXL	Ljava/util/HashMap;
          //   1520: aload_0
          //   1521: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1524: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1527: getfield 284	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
          //   1530: invokevirtual 287	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
          //   1533: invokevirtual 294	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1536: checkcast 187	java/lang/String
          //   1539: astore 5
          //   1541: aload 5
          //   1543: astore_1
          //   1544: aload 5
          //   1546: ifnonnull +19 -> 1565
          //   1549: aload_0
          //   1550: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1553: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1556: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   1559: ldc 236
          //   1561: invokevirtual 232	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
          //   1564: astore_1
          //   1565: aload_0
          //   1566: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1569: ldc_w 341
          //   1572: bipush 43
          //   1574: invokevirtual 345	com/tencent/mm/plugin/webview/ui/tools/o:ie	(Ljava/lang/String;I)V
          //   1577: aload_0
          //   1578: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1581: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1584: aload_1
          //   1585: invokevirtual 348	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:blQ	(Ljava/lang/String;)V
          //   1588: ldc 34
          //   1590: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1593: return
          //   1594: aload_0
          //   1595: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1598: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1601: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1604: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1607: iconst_3
          //   1608: anewarray 4	java/lang/Object
          //   1611: dup
          //   1612: iconst_0
          //   1613: aload_0
          //   1614: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1617: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1620: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1623: aastore
          //   1624: dup
          //   1625: iconst_1
          //   1626: bipush 8
          //   1628: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1631: aastore
          //   1632: dup
          //   1633: iconst_2
          //   1634: iconst_1
          //   1635: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1638: aastore
          //   1639: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1642: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1645: aload_0
          //   1646: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1649: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1652: getfield 352	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWW	Landroid/view/View;
          //   1655: invokevirtual 357	android/view/View:getVisibility	()I
          //   1658: bipush 8
          //   1660: if_icmpne +51 -> 1711
          //   1663: aload_0
          //   1664: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1667: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1670: getstatic 362	com/tencent/mm/plugin/webview/c$a:font_fade_in	I
          //   1673: invokestatic 368	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1676: astore_1
          //   1677: aload_0
          //   1678: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1681: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1684: getfield 352	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWW	Landroid/view/View;
          //   1687: aload_1
          //   1688: invokevirtual 372	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1691: aload_0
          //   1692: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1695: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1698: getfield 352	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWW	Landroid/view/View;
          //   1701: iconst_0
          //   1702: invokevirtual 375	android/view/View:setVisibility	(I)V
          //   1705: ldc 34
          //   1707: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1710: return
          //   1711: aload_0
          //   1712: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1715: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1718: getstatic 378	com/tencent/mm/plugin/webview/c$a:font_fade_out	I
          //   1721: invokestatic 368	android/view/animation/AnimationUtils:loadAnimation	(Landroid/content/Context;I)Landroid/view/animation/Animation;
          //   1724: astore_1
          //   1725: aload_1
          //   1726: new 13	com/tencent/mm/plugin/webview/ui/tools/o$2$1
          //   1729: dup
          //   1730: aload_0
          //   1731: invokespecial 381	com/tencent/mm/plugin/webview/ui/tools/o$2$1:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o$2;)V
          //   1734: invokevirtual 387	android/view/animation/Animation:setAnimationListener	(Landroid/view/animation/Animation$AnimationListener;)V
          //   1737: aload_0
          //   1738: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1741: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1744: getfield 352	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWW	Landroid/view/View;
          //   1747: aload_1
          //   1748: invokevirtual 372	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
          //   1751: aload_0
          //   1752: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1755: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1758: getfield 352	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WWW	Landroid/view/View;
          //   1761: bipush 8
          //   1763: invokevirtual 375	android/view/View:setVisibility	(I)V
          //   1766: ldc 34
          //   1768: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1771: return
          //   1772: aload_0
          //   1773: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1776: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1779: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1782: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1785: iconst_3
          //   1786: anewarray 4	java/lang/Object
          //   1789: dup
          //   1790: iconst_0
          //   1791: aload_0
          //   1792: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1795: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1798: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1801: aastore
          //   1802: dup
          //   1803: iconst_1
          //   1804: bipush 10
          //   1806: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1809: aastore
          //   1810: dup
          //   1811: iconst_2
          //   1812: iconst_1
          //   1813: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1816: aastore
          //   1817: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1820: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1823: aload_0
          //   1824: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1827: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1830: astore_1
          //   1831: aload_1
          //   1832: getfield 391	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   1835: invokevirtual 396	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:cuZ	()Z
          //   1838: ifeq +12 -> 1850
          //   1841: aload_1
          //   1842: getfield 391	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   1845: iconst_0
          //   1846: invokevirtual 400	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:IY	(Z)Z
          //   1849: pop
          //   1850: aload_1
          //   1851: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   1854: ifnull +10 -> 1864
          //   1857: aload_1
          //   1858: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   1861: invokevirtual 409	com/tencent/mm/plugin/webview/core/k:reload	()V
          //   1864: ldc 34
          //   1866: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1869: return
          //   1870: aload_0
          //   1871: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1874: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1877: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1880: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1883: iconst_3
          //   1884: anewarray 4	java/lang/Object
          //   1887: dup
          //   1888: iconst_0
          //   1889: aload_0
          //   1890: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1893: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1896: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1899: aastore
          //   1900: dup
          //   1901: iconst_1
          //   1902: iconst_5
          //   1903: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1906: aastore
          //   1907: dup
          //   1908: iconst_2
          //   1909: iconst_1
          //   1910: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1913: aastore
          //   1914: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1917: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   1920: aload_0
          //   1921: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1924: invokestatic 412	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   1927: ldc 34
          //   1929: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1932: return
          //   1933: aconst_null
          //   1934: astore_1
          //   1935: aload_0
          //   1936: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1939: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1942: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   1945: ifnull +17 -> 1962
          //   1948: aload_0
          //   1949: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1952: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1955: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   1958: invokevirtual 416	com/tencent/mm/plugin/webview/core/k:irI	()Lcom/tencent/mm/plugin/webview/e/c;
          //   1961: astore_1
          //   1962: aload_1
          //   1963: ifnull +143 -> 2106
          //   1966: aload_0
          //   1967: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1970: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1973: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   1976: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   1979: pop
          //   1980: bipush 14
          //   1982: anewarray 4	java/lang/Object
          //   1985: dup
          //   1986: iconst_0
          //   1987: aload_0
          //   1988: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   1991: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   1994: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   1997: aastore
          //   1998: dup
          //   1999: iconst_1
          //   2000: bipush 13
          //   2002: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2005: aastore
          //   2006: dup
          //   2007: iconst_2
          //   2008: iconst_1
          //   2009: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2012: aastore
          //   2013: dup
          //   2014: iconst_3
          //   2015: ldc_w 418
          //   2018: aastore
          //   2019: dup
          //   2020: iconst_4
          //   2021: ldc_w 418
          //   2024: aastore
          //   2025: dup
          //   2026: iconst_5
          //   2027: ldc_w 418
          //   2030: aastore
          //   2031: dup
          //   2032: bipush 6
          //   2034: iconst_0
          //   2035: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2038: aastore
          //   2039: dup
          //   2040: bipush 7
          //   2042: ldc_w 418
          //   2045: aastore
          //   2046: dup
          //   2047: bipush 8
          //   2049: aload_1
          //   2050: getfield 423	com/tencent/mm/plugin/webview/e/c:sWX	Ljava/lang/String;
          //   2053: aastore
          //   2054: dup
          //   2055: bipush 9
          //   2057: aload_1
          //   2058: getfield 426	com/tencent/mm/plugin/webview/e/c:WOQ	I
          //   2061: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2064: aastore
          //   2065: dup
          //   2066: bipush 10
          //   2068: aload_1
          //   2069: getfield 429	com/tencent/mm/plugin/webview/e/c:WPa	Ljava/lang/String;
          //   2072: aastore
          //   2073: dup
          //   2074: bipush 11
          //   2076: aload_1
          //   2077: getfield 432	com/tencent/mm/plugin/webview/e/c:WOZ	Ljava/lang/String;
          //   2080: aastore
          //   2081: dup
          //   2082: bipush 12
          //   2084: aload_1
          //   2085: getfield 435	com/tencent/mm/plugin/webview/e/c:WPe	I
          //   2088: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2091: aastore
          //   2092: dup
          //   2093: bipush 13
          //   2095: aload_1
          //   2096: getfield 438	com/tencent/mm/plugin/webview/e/c:OqQ	I
          //   2099: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2102: aastore
          //   2103: invokestatic 442	com/tencent/mm/plugin/webview/model/ba$d:G	([Ljava/lang/Object;)V
          //   2106: aload_0
          //   2107: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2110: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2113: astore 6
          //   2115: aload_0
          //   2116: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2119: astore_1
          //   2120: aload 6
          //   2122: getfield 446	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYE	Lcom/tencent/mm/plugin/webview/modeltools/a;
          //   2125: astore 7
          //   2127: aload 6
          //   2129: getfield 450	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   2132: astore 8
          //   2134: aload 6
          //   2136: invokevirtual 453	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   2139: ifne +227 -> 2366
          //   2142: aload 7
          //   2144: new 455	java/lang/ref/WeakReference
          //   2147: dup
          //   2148: aload_1
          //   2149: invokespecial 458	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
          //   2152: putfield 464	com/tencent/mm/plugin/webview/modeltools/a:WNn	Ljava/lang/ref/WeakReference;
          //   2155: aload 6
          //   2157: invokevirtual 467	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fqa	()Ljava/lang/String;
          //   2160: astore 5
          //   2162: aload 5
          //   2164: invokestatic 473	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   2167: ifeq +18 -> 2185
          //   2170: ldc_w 475
          //   2173: ldc_w 477
          //   2176: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2179: ldc 34
          //   2181: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2184: return
          //   2185: aload 5
          //   2187: astore_1
          //   2188: aload 8
          //   2190: ifnull +13 -> 2203
          //   2193: aload 8
          //   2195: aload 5
          //   2197: invokeinterface 482 2 0
          //   2202: astore_1
          //   2203: aload_1
          //   2204: astore 5
          //   2206: aload_1
          //   2207: ldc_w 484
          //   2210: invokevirtual 487	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2213: ifne +28 -> 2241
          //   2216: aload_1
          //   2217: astore 5
          //   2219: aload_1
          //   2220: ldc_w 489
          //   2223: invokevirtual 487	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2226: ifne +15 -> 2241
          //   2229: ldc_w 484
          //   2232: aload_1
          //   2233: invokestatic 492	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2236: invokevirtual 495	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2239: astore 5
          //   2241: new 228	android/content/Intent
          //   2244: dup
          //   2245: ldc_w 497
          //   2248: aload 5
          //   2250: invokestatic 503	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2253: invokespecial 506	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2256: astore_1
          //   2257: aload 6
          //   2259: invokestatic 510	com/tencent/mm/sdk/platformtools/Util:isOverseasUser	(Landroid/content/Context;)Z
          //   2262: ifne +9 -> 2271
          //   2265: invokestatic 515	com/tencent/mm/sdk/platformtools/ChannelUtil:isGPVersion	()Z
          //   2268: ifeq +209 -> 2477
          //   2271: ldc_w 475
          //   2274: ldc_w 517
          //   2277: iconst_2
          //   2278: anewarray 4	java/lang/Object
          //   2281: dup
          //   2282: iconst_0
          //   2283: aload 6
          //   2285: invokestatic 510	com/tencent/mm/sdk/platformtools/Util:isOverseasUser	(Landroid/content/Context;)Z
          //   2288: invokestatic 522	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2291: aastore
          //   2292: dup
          //   2293: iconst_1
          //   2294: invokestatic 515	com/tencent/mm/sdk/platformtools/ChannelUtil:isGPVersion	()Z
          //   2297: invokestatic 522	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   2300: aastore
          //   2301: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2304: bipush 29
          //   2306: invokestatic 528	com/tencent/mm/compatible/util/d:rb	(I)Z
          //   2309: ifeq +87 -> 2396
          //   2312: aload 6
          //   2314: iconst_0
          //   2315: aload_1
          //   2316: ldc_w 529
          //   2319: invokestatic 535	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
          //   2322: aload 6
          //   2324: iconst_1
          //   2325: aconst_null
          //   2326: new 537	com/tencent/mm/plugin/webview/modeltools/a$1
          //   2329: dup
          //   2330: aload 7
          //   2332: invokespecial 540	com/tencent/mm/plugin/webview/modeltools/a$1:<init>	(Lcom/tencent/mm/plugin/webview/modeltools/a;)V
          //   2335: aconst_null
          //   2336: invokevirtual 544	android/app/PendingIntent:send	(Landroid/content/Context;ILandroid/content/Intent;Landroid/app/PendingIntent$OnFinished;Landroid/os/Handler;)V
          //   2339: ldc 34
          //   2341: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2344: return
          //   2345: astore_1
          //   2346: ldc_w 475
          //   2349: ldc_w 546
          //   2352: iconst_1
          //   2353: anewarray 4	java/lang/Object
          //   2356: dup
          //   2357: iconst_0
          //   2358: aload_1
          //   2359: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   2362: aastore
          //   2363: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2366: ldc 34
          //   2368: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2371: return
          //   2372: astore_1
          //   2373: ldc_w 475
          //   2376: ldc_w 553
          //   2379: iconst_1
          //   2380: anewarray 4	java/lang/Object
          //   2383: dup
          //   2384: iconst_0
          //   2385: aload_1
          //   2386: aastore
          //   2387: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2390: aload 5
          //   2392: astore_1
          //   2393: goto -190 -> 2203
          //   2396: new 555	com/tencent/mm/hellhoundlib/b/a
          //   2399: dup
          //   2400: invokespecial 556	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   2403: aload_1
          //   2404: invokevirtual 560	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   2407: astore_1
          //   2408: aload 6
          //   2410: aload_1
          //   2411: invokevirtual 564	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
          //   2414: ldc_w 566
          //   2417: ldc_w 568
          //   2420: ldc_w 570
          //   2423: ldc_w 572
          //   2426: ldc_w 574
          //   2429: ldc_w 576
          //   2432: invokestatic 581	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2435: aload 6
          //   2437: aload_1
          //   2438: iconst_0
          //   2439: invokevirtual 584	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
          //   2442: checkcast 228	android/content/Intent
          //   2445: invokevirtual 586	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivity	(Landroid/content/Intent;)V
          //   2448: aload 6
          //   2450: ldc_w 566
          //   2453: ldc_w 568
          //   2456: ldc_w 570
          //   2459: ldc_w 572
          //   2462: ldc_w 574
          //   2465: ldc_w 576
          //   2468: invokestatic 590	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   2471: ldc 34
          //   2473: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2476: return
          //   2477: aload 6
          //   2479: aload 6
          //   2481: aload_1
          //   2482: aload 5
          //   2484: invokestatic 595	com/tencent/mm/plugin/webview/ui/tools/browser/b:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Landroid/content/Intent;
          //   2487: sipush 205
          //   2490: invokevirtual 599	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:startActivityForResult	(Landroid/content/Intent;I)V
          //   2493: ldc 34
          //   2495: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2498: return
          //   2499: ldc_w 418
          //   2502: astore 5
          //   2504: aload_0
          //   2505: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2508: getfield 603	com/tencent/mm/plugin/webview/ui/tools/o:WVl	Lcom/tencent/mm/plugin/webview/ui/tools/browser/f;
          //   2511: getfield 609	com/tencent/mm/plugin/webview/ui/tools/browser/f:qK	Landroid/content/pm/ResolveInfo;
          //   2514: astore 6
          //   2516: aload 5
          //   2518: astore_1
          //   2519: aload 6
          //   2521: ifnull +29 -> 2550
          //   2524: aload 5
          //   2526: astore_1
          //   2527: aload 6
          //   2529: getfield 615	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
          //   2532: ifnull +18 -> 2550
          //   2535: aload 6
          //   2537: getfield 615	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
          //   2540: getfield 620	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
          //   2543: ldc_w 418
          //   2546: invokestatic 624	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
          //   2549: astore_1
          //   2550: aconst_null
          //   2551: astore 5
          //   2553: aload_0
          //   2554: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2557: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2560: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   2563: ifnull +18 -> 2581
          //   2566: aload_0
          //   2567: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2570: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2573: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   2576: invokevirtual 416	com/tencent/mm/plugin/webview/core/k:irI	()Lcom/tencent/mm/plugin/webview/e/c;
          //   2579: astore 5
          //   2581: aload 5
          //   2583: ifnull +147 -> 2730
          //   2586: aload_0
          //   2587: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2590: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2593: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   2596: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2599: pop
          //   2600: bipush 14
          //   2602: anewarray 4	java/lang/Object
          //   2605: dup
          //   2606: iconst_0
          //   2607: aload_0
          //   2608: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2611: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2614: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   2617: aastore
          //   2618: dup
          //   2619: iconst_1
          //   2620: bipush 39
          //   2622: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2625: aastore
          //   2626: dup
          //   2627: iconst_2
          //   2628: iconst_3
          //   2629: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2632: aastore
          //   2633: dup
          //   2634: iconst_3
          //   2635: ldc_w 418
          //   2638: aastore
          //   2639: dup
          //   2640: iconst_4
          //   2641: ldc_w 418
          //   2644: aastore
          //   2645: dup
          //   2646: iconst_5
          //   2647: ldc_w 418
          //   2650: aastore
          //   2651: dup
          //   2652: bipush 6
          //   2654: iconst_0
          //   2655: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2658: aastore
          //   2659: dup
          //   2660: bipush 7
          //   2662: aload_1
          //   2663: aastore
          //   2664: dup
          //   2665: bipush 8
          //   2667: aload 5
          //   2669: getfield 423	com/tencent/mm/plugin/webview/e/c:sWX	Ljava/lang/String;
          //   2672: aastore
          //   2673: dup
          //   2674: bipush 9
          //   2676: aload 5
          //   2678: getfield 426	com/tencent/mm/plugin/webview/e/c:WOQ	I
          //   2681: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2684: aastore
          //   2685: dup
          //   2686: bipush 10
          //   2688: aload 5
          //   2690: getfield 429	com/tencent/mm/plugin/webview/e/c:WPa	Ljava/lang/String;
          //   2693: aastore
          //   2694: dup
          //   2695: bipush 11
          //   2697: aload 5
          //   2699: getfield 432	com/tencent/mm/plugin/webview/e/c:WOZ	Ljava/lang/String;
          //   2702: aastore
          //   2703: dup
          //   2704: bipush 12
          //   2706: aload 5
          //   2708: getfield 435	com/tencent/mm/plugin/webview/e/c:WPe	I
          //   2711: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2714: aastore
          //   2715: dup
          //   2716: bipush 13
          //   2718: aload 5
          //   2720: getfield 438	com/tencent/mm/plugin/webview/e/c:OqQ	I
          //   2723: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2726: aastore
          //   2727: invokestatic 442	com/tencent/mm/plugin/webview/model/ba$d:G	([Ljava/lang/Object;)V
          //   2730: aload_0
          //   2731: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2734: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2737: astore 7
          //   2739: aload 7
          //   2741: getfield 450	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   2744: astore 8
          //   2746: aload 7
          //   2748: invokevirtual 453	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:isFinishing	()Z
          //   2751: ifne +123 -> 2874
          //   2754: aload 7
          //   2756: invokevirtual 467	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fqa	()Ljava/lang/String;
          //   2759: astore 5
          //   2761: aload 5
          //   2763: invokestatic 473	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   2766: ifeq +18 -> 2784
          //   2769: ldc_w 475
          //   2772: ldc_w 477
          //   2775: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   2778: ldc 34
          //   2780: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2783: return
          //   2784: aload 5
          //   2786: astore_1
          //   2787: aload 8
          //   2789: ifnull +13 -> 2802
          //   2792: aload 8
          //   2794: aload 5
          //   2796: invokeinterface 482 2 0
          //   2801: astore_1
          //   2802: aload_1
          //   2803: astore 5
          //   2805: aload_1
          //   2806: ldc_w 484
          //   2809: invokevirtual 487	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2812: ifne +28 -> 2840
          //   2815: aload_1
          //   2816: astore 5
          //   2818: aload_1
          //   2819: ldc_w 489
          //   2822: invokevirtual 487	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   2825: ifne +15 -> 2840
          //   2828: ldc_w 484
          //   2831: aload_1
          //   2832: invokestatic 492	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   2835: invokevirtual 495	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   2838: astore 5
          //   2840: new 228	android/content/Intent
          //   2843: dup
          //   2844: ldc_w 497
          //   2847: aload 5
          //   2849: invokestatic 503	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   2852: invokespecial 506	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
          //   2855: astore_1
          //   2856: aload_1
          //   2857: ldc_w 626
          //   2860: aload 5
          //   2862: invokevirtual 251	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
          //   2865: pop
          //   2866: aload 7
          //   2868: aload_1
          //   2869: aload 6
          //   2871: invokestatic 629	com/tencent/mm/plugin/webview/ui/tools/browser/b:a	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/pm/ResolveInfo;)V
          //   2874: ldc 34
          //   2876: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2879: return
          //   2880: astore_1
          //   2881: ldc_w 475
          //   2884: ldc_w 553
          //   2887: iconst_1
          //   2888: anewarray 4	java/lang/Object
          //   2891: dup
          //   2892: iconst_0
          //   2893: aload_1
          //   2894: aastore
          //   2895: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2898: aload 5
          //   2900: astore_1
          //   2901: goto -99 -> 2802
          //   2904: aload_0
          //   2905: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2908: invokestatic 631	com/tencent/mm/plugin/webview/ui/tools/o:b	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   2911: ldc 34
          //   2913: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2916: return
          //   2917: aload_0
          //   2918: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2921: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2924: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   2927: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2930: iconst_3
          //   2931: anewarray 4	java/lang/Object
          //   2934: dup
          //   2935: iconst_0
          //   2936: aload_0
          //   2937: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2940: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2943: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   2946: aastore
          //   2947: dup
          //   2948: iconst_1
          //   2949: bipush 15
          //   2951: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2954: aastore
          //   2955: dup
          //   2956: iconst_2
          //   2957: iconst_1
          //   2958: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2961: aastore
          //   2962: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   2965: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   2968: aload_0
          //   2969: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   2972: astore_1
          //   2973: aload_1
          //   2974: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2977: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   2980: ldc_w 633
          //   2983: iconst_1
          //   2984: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   2987: aload_1
          //   2988: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   2991: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   2994: astore_1
          //   2995: aload_1
          //   2996: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   2999: ifne +17 -> 3016
          //   3002: ldc 77
          //   3004: ldc_w 639
          //   3007: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3010: ldc 34
          //   3012: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3015: return
          //   3016: ldc_w 641
          //   3019: new 91	java/util/HashMap
          //   3022: dup
          //   3023: invokespecial 92	java/util/HashMap:<init>	()V
          //   3026: aload_1
          //   3027: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   3030: aload_1
          //   3031: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   3034: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3037: astore 5
          //   3039: aload_1
          //   3040: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3043: new 125	java/lang/StringBuilder
          //   3046: dup
          //   3047: ldc 127
          //   3049: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3052: aload 5
          //   3054: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3057: ldc 136
          //   3059: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3062: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3065: aconst_null
          //   3066: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3069: ldc 34
          //   3071: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3074: return
          //   3075: aload_0
          //   3076: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3079: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3082: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3085: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3088: iconst_3
          //   3089: anewarray 4	java/lang/Object
          //   3092: dup
          //   3093: iconst_0
          //   3094: aload_0
          //   3095: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3098: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3101: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3104: aastore
          //   3105: dup
          //   3106: iconst_1
          //   3107: bipush 7
          //   3109: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3112: aastore
          //   3113: dup
          //   3114: iconst_2
          //   3115: iconst_1
          //   3116: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3119: aastore
          //   3120: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3123: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3126: aload_0
          //   3127: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3130: astore_1
          //   3131: aload_1
          //   3132: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3135: aload_1
          //   3136: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3139: getstatic 646	com/tencent/mm/plugin/webview/c$i:app_delete_tips	I
          //   3142: invokevirtual 650	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3145: aconst_null
          //   3146: aconst_null
          //   3147: aload_1
          //   3148: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3151: getstatic 653	com/tencent/mm/plugin/webview/c$i:app_delete	I
          //   3154: invokevirtual 650	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
          //   3157: new 655	com/tencent/mm/plugin/webview/ui/tools/o$19
          //   3160: dup
          //   3161: aload_1
          //   3162: invokespecial 657	com/tencent/mm/plugin/webview/ui/tools/o$19:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   3165: invokestatic 662	com/tencent/mm/ui/base/k:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/ui/base/k$e;)Landroid/app/Dialog;
          //   3168: pop
          //   3169: ldc 34
          //   3171: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3174: return
          //   3175: aload_0
          //   3176: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3179: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3182: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3185: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3188: iconst_3
          //   3189: anewarray 4	java/lang/Object
          //   3192: dup
          //   3193: iconst_0
          //   3194: aload_0
          //   3195: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3198: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3201: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3204: aastore
          //   3205: dup
          //   3206: iconst_1
          //   3207: bipush 11
          //   3209: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3212: aastore
          //   3213: dup
          //   3214: iconst_2
          //   3215: iconst_1
          //   3216: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3219: aastore
          //   3220: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3223: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3226: aload_0
          //   3227: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3230: aconst_null
          //   3231: invokevirtual 665	com/tencent/mm/plugin/webview/ui/tools/o:blJ	(Ljava/lang/String;)V
          //   3234: ldc 34
          //   3236: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3239: return
          //   3240: aload_0
          //   3241: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3244: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3247: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3250: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3253: iconst_3
          //   3254: anewarray 4	java/lang/Object
          //   3257: dup
          //   3258: iconst_0
          //   3259: aload_0
          //   3260: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3263: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3266: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3269: aastore
          //   3270: dup
          //   3271: iconst_1
          //   3272: bipush 6
          //   3274: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3277: aastore
          //   3278: dup
          //   3279: iconst_2
          //   3280: iconst_1
          //   3281: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3284: aastore
          //   3285: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3288: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3291: new 228	android/content/Intent
          //   3294: dup
          //   3295: invokespecial 240	android/content/Intent:<init>	()V
          //   3298: astore_1
          //   3299: aload_1
          //   3300: ldc_w 667
          //   3303: iconst_2
          //   3304: invokevirtual 670	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   3307: pop
          //   3308: aload_1
          //   3309: ldc_w 672
          //   3312: aload_0
          //   3313: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3316: invokevirtual 220	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3319: invokevirtual 224	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
          //   3322: ldc_w 674
          //   3325: ldc2_w 675
          //   3328: invokevirtual 269	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
          //   3331: invokevirtual 679	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
          //   3334: pop
          //   3335: aload_0
          //   3336: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3339: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3342: ldc_w 681
          //   3345: aload_1
          //   3346: invokestatic 685	com/tencent/mm/plugin/fav/a/b:b	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V
          //   3349: aload_0
          //   3350: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3353: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3356: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3359: ldc_w 687
          //   3362: invokevirtual 690	com/tencent/mm/plugin/webview/model/ba:bkF	(Ljava/lang/String;)V
          //   3365: ldc 34
          //   3367: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3370: return
          //   3371: aload_0
          //   3372: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3375: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3378: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3381: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3384: iconst_3
          //   3385: anewarray 4	java/lang/Object
          //   3388: dup
          //   3389: iconst_0
          //   3390: aload_0
          //   3391: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3394: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3397: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3400: aastore
          //   3401: dup
          //   3402: iconst_1
          //   3403: bipush 19
          //   3405: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3408: aastore
          //   3409: dup
          //   3410: iconst_2
          //   3411: iconst_1
          //   3412: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3415: aastore
          //   3416: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3419: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3422: aload_0
          //   3423: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3426: aload_1
          //   3427: invokestatic 693	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/view/MenuItem;)V
          //   3430: ldc 34
          //   3432: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3435: return
          //   3436: aload_0
          //   3437: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3440: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3443: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3446: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3449: iconst_3
          //   3450: anewarray 4	java/lang/Object
          //   3453: dup
          //   3454: iconst_0
          //   3455: aload_0
          //   3456: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3459: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3462: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3465: aastore
          //   3466: dup
          //   3467: iconst_1
          //   3468: bipush 21
          //   3470: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3473: aastore
          //   3474: dup
          //   3475: iconst_2
          //   3476: iconst_1
          //   3477: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3480: aastore
          //   3481: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3484: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3487: aload_0
          //   3488: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3491: aload_1
          //   3492: invokestatic 693	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/view/MenuItem;)V
          //   3495: ldc 34
          //   3497: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3500: return
          //   3501: aload_0
          //   3502: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3505: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3508: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3511: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3514: iconst_3
          //   3515: anewarray 4	java/lang/Object
          //   3518: dup
          //   3519: iconst_0
          //   3520: aload_0
          //   3521: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3524: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3527: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3530: aastore
          //   3531: dup
          //   3532: iconst_1
          //   3533: bipush 20
          //   3535: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3538: aastore
          //   3539: dup
          //   3540: iconst_2
          //   3541: iconst_1
          //   3542: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3545: aastore
          //   3546: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3549: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3552: aload_0
          //   3553: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3556: aload_1
          //   3557: invokestatic 693	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/view/MenuItem;)V
          //   3560: ldc 34
          //   3562: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3565: return
          //   3566: aload_0
          //   3567: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3570: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3573: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3576: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3579: iconst_3
          //   3580: anewarray 4	java/lang/Object
          //   3583: dup
          //   3584: iconst_0
          //   3585: aload_0
          //   3586: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3589: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3592: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3595: aastore
          //   3596: dup
          //   3597: iconst_1
          //   3598: bipush 22
          //   3600: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3603: aastore
          //   3604: dup
          //   3605: iconst_2
          //   3606: iconst_1
          //   3607: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3610: aastore
          //   3611: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3614: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3617: aload_0
          //   3618: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3621: aload_1
          //   3622: invokestatic 693	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/view/MenuItem;)V
          //   3625: ldc 34
          //   3627: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3630: return
          //   3631: aload_0
          //   3632: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3635: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3638: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3641: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3644: iconst_3
          //   3645: anewarray 4	java/lang/Object
          //   3648: dup
          //   3649: iconst_0
          //   3650: aload_0
          //   3651: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3654: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3657: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3660: aastore
          //   3661: dup
          //   3662: iconst_1
          //   3663: bipush 23
          //   3665: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3668: aastore
          //   3669: dup
          //   3670: iconst_2
          //   3671: iconst_1
          //   3672: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3675: aastore
          //   3676: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3679: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3682: aload_0
          //   3683: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3686: aload_1
          //   3687: invokestatic 693	com/tencent/mm/plugin/webview/ui/tools/o:a	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/view/MenuItem;)V
          //   3690: ldc 34
          //   3692: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3695: return
          //   3696: aload_0
          //   3697: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3700: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3703: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3706: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3709: iconst_3
          //   3710: anewarray 4	java/lang/Object
          //   3713: dup
          //   3714: iconst_0
          //   3715: aload_0
          //   3716: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3719: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3722: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3725: aastore
          //   3726: dup
          //   3727: iconst_1
          //   3728: bipush 26
          //   3730: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3733: aastore
          //   3734: dup
          //   3735: iconst_2
          //   3736: iconst_1
          //   3737: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3740: aastore
          //   3741: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3744: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3747: aload_0
          //   3748: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3751: astore 5
          //   3753: aload_1
          //   3754: invokeinterface 150 1 0
          //   3759: istore_2
          //   3760: aload 5
          //   3762: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3765: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   3768: ldc_w 695
          //   3771: iconst_1
          //   3772: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   3775: aload 5
          //   3777: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3780: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   3783: astore 5
          //   3785: iload_2
          //   3786: bipush 43
          //   3788: if_icmpne +29 -> 3817
          //   3791: ldc_w 697
          //   3794: astore_1
          //   3795: aload 5
          //   3797: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   3800: ifne +24 -> 3824
          //   3803: ldc 77
          //   3805: ldc_w 699
          //   3808: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   3811: ldc 34
          //   3813: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3816: return
          //   3817: ldc_w 701
          //   3820: astore_1
          //   3821: goto -26 -> 3795
          //   3824: ldc_w 703
          //   3827: new 91	java/util/HashMap
          //   3830: dup
          //   3831: invokespecial 92	java/util/HashMap:<init>	()V
          //   3834: aload 5
          //   3836: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   3839: aload 5
          //   3841: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   3844: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   3847: astore 6
          //   3849: aload 5
          //   3851: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   3854: new 125	java/lang/StringBuilder
          //   3857: dup
          //   3858: ldc 127
          //   3860: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3863: aload 6
          //   3865: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3868: ldc 136
          //   3870: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3873: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3876: aconst_null
          //   3877: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   3880: aload 5
          //   3882: getfield 704	com/tencent/mm/plugin/webview/jsapi/j:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   3885: ldc_w 706
          //   3888: aload_1
          //   3889: aload 5
          //   3891: getfield 709	com/tencent/mm/plugin/webview/jsapi/j:WDK	I
          //   3894: invokeinterface 713 4 0
          //   3899: ldc 34
          //   3901: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3904: return
          //   3905: astore_1
          //   3906: ldc 77
          //   3908: new 125	java/lang/StringBuilder
          //   3911: dup
          //   3912: ldc_w 715
          //   3915: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   3918: aload_1
          //   3919: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   3922: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   3925: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   3928: invokestatic 718	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   3931: ldc 34
          //   3933: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   3936: return
          //   3937: aload_0
          //   3938: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3941: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3944: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   3947: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3950: iconst_3
          //   3951: anewarray 4	java/lang/Object
          //   3954: dup
          //   3955: iconst_0
          //   3956: aload_0
          //   3957: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3960: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   3963: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   3966: aastore
          //   3967: dup
          //   3968: iconst_1
          //   3969: bipush 27
          //   3971: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3974: aastore
          //   3975: dup
          //   3976: iconst_2
          //   3977: iconst_1
          //   3978: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   3981: aastore
          //   3982: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   3985: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   3988: aload_0
          //   3989: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   3992: invokestatic 720	com/tencent/mm/plugin/webview/ui/tools/o:c	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   3995: ldc 34
          //   3997: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4000: return
          //   4001: aload_0
          //   4002: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4005: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4008: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4011: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4014: iconst_3
          //   4015: anewarray 4	java/lang/Object
          //   4018: dup
          //   4019: iconst_0
          //   4020: aload_0
          //   4021: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4024: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4027: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   4030: aastore
          //   4031: dup
          //   4032: iconst_1
          //   4033: bipush 17
          //   4035: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4038: aastore
          //   4039: dup
          //   4040: iconst_2
          //   4041: iconst_1
          //   4042: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4045: aastore
          //   4046: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4049: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4052: aload_0
          //   4053: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4056: astore_1
          //   4057: aload_1
          //   4058: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4061: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4064: ldc_w 722
          //   4067: iconst_1
          //   4068: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   4071: aload_1
          //   4072: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4075: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4078: astore_1
          //   4079: aload_1
          //   4080: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   4083: ifne +17 -> 4100
          //   4086: ldc 77
          //   4088: ldc_w 724
          //   4091: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4094: ldc 34
          //   4096: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4099: return
          //   4100: aload_1
          //   4101: iconst_1
          //   4102: invokevirtual 728	com/tencent/mm/plugin/webview/jsapi/j:atC	(I)Landroid/os/Bundle;
          //   4105: astore 5
          //   4107: aload 5
          //   4109: ifnull +30 -> 4139
          //   4112: aload 5
          //   4114: ldc_w 730
          //   4117: iconst_0
          //   4118: invokevirtual 736	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   4121: ifeq +18 -> 4139
          //   4124: aload_1
          //   4125: aload 5
          //   4127: ldc_w 722
          //   4130: invokevirtual 739	com/tencent/mm/plugin/webview/jsapi/j:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   4133: ldc 34
          //   4135: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4138: return
          //   4139: ldc_w 741
          //   4142: new 91	java/util/HashMap
          //   4145: dup
          //   4146: invokespecial 92	java/util/HashMap:<init>	()V
          //   4149: aload_1
          //   4150: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   4153: aload_1
          //   4154: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   4157: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4160: astore 5
          //   4162: aload_1
          //   4163: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4166: new 125	java/lang/StringBuilder
          //   4169: dup
          //   4170: ldc 127
          //   4172: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4175: aload 5
          //   4177: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4180: ldc 136
          //   4182: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4185: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4188: aconst_null
          //   4189: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4192: ldc 34
          //   4194: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4197: return
          //   4198: aload_0
          //   4199: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4202: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4205: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4208: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4211: iconst_3
          //   4212: anewarray 4	java/lang/Object
          //   4215: dup
          //   4216: iconst_0
          //   4217: aload_0
          //   4218: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4221: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4224: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   4227: aastore
          //   4228: dup
          //   4229: iconst_1
          //   4230: bipush 18
          //   4232: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4235: aastore
          //   4236: dup
          //   4237: iconst_2
          //   4238: iconst_1
          //   4239: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4242: aastore
          //   4243: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4246: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4249: aload_0
          //   4250: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4253: astore_1
          //   4254: aload_1
          //   4255: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4258: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4261: ldc_w 743
          //   4264: iconst_1
          //   4265: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   4268: aload_1
          //   4269: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4272: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4275: astore_1
          //   4276: aload_1
          //   4277: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   4280: ifne +17 -> 4297
          //   4283: ldc 77
          //   4285: ldc_w 745
          //   4288: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4291: ldc 34
          //   4293: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4296: return
          //   4297: ldc_w 747
          //   4300: new 91	java/util/HashMap
          //   4303: dup
          //   4304: invokespecial 92	java/util/HashMap:<init>	()V
          //   4307: aload_1
          //   4308: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   4311: aload_1
          //   4312: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   4315: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4318: astore 5
          //   4320: aload_1
          //   4321: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4324: new 125	java/lang/StringBuilder
          //   4327: dup
          //   4328: ldc 127
          //   4330: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4333: aload 5
          //   4335: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4338: ldc 136
          //   4340: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4343: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4346: aconst_null
          //   4347: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4350: ldc 34
          //   4352: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4355: return
          //   4356: aload_0
          //   4357: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4360: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4363: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4366: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4369: iconst_3
          //   4370: anewarray 4	java/lang/Object
          //   4373: dup
          //   4374: iconst_0
          //   4375: aload_0
          //   4376: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4379: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4382: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   4385: aastore
          //   4386: dup
          //   4387: iconst_1
          //   4388: bipush 24
          //   4390: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4393: aastore
          //   4394: dup
          //   4395: iconst_2
          //   4396: iconst_1
          //   4397: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4400: aastore
          //   4401: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4404: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4407: aload_0
          //   4408: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4411: astore_1
          //   4412: aload_1
          //   4413: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4416: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4419: ldc_w 749
          //   4422: iconst_1
          //   4423: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   4426: aload_1
          //   4427: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4430: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4433: astore_1
          //   4434: aload_1
          //   4435: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   4438: ifne +17 -> 4455
          //   4441: ldc 77
          //   4443: ldc_w 751
          //   4446: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4449: ldc 34
          //   4451: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4454: return
          //   4455: aload_1
          //   4456: iconst_1
          //   4457: invokevirtual 728	com/tencent/mm/plugin/webview/jsapi/j:atC	(I)Landroid/os/Bundle;
          //   4460: astore 5
          //   4462: aload 5
          //   4464: ifnull +30 -> 4494
          //   4467: aload 5
          //   4469: ldc_w 730
          //   4472: iconst_0
          //   4473: invokevirtual 736	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
          //   4476: ifeq +18 -> 4494
          //   4479: aload_1
          //   4480: aload 5
          //   4482: ldc_w 749
          //   4485: invokevirtual 739	com/tencent/mm/plugin/webview/jsapi/j:i	(Landroid/os/Bundle;Ljava/lang/String;)V
          //   4488: ldc 34
          //   4490: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4493: return
          //   4494: ldc_w 753
          //   4497: new 91	java/util/HashMap
          //   4500: dup
          //   4501: invokespecial 92	java/util/HashMap:<init>	()V
          //   4504: aload_1
          //   4505: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   4508: aload_1
          //   4509: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   4512: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4515: astore 5
          //   4517: aload_1
          //   4518: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4521: new 125	java/lang/StringBuilder
          //   4524: dup
          //   4525: ldc 127
          //   4527: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4530: aload 5
          //   4532: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4535: ldc 136
          //   4537: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4540: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4543: aconst_null
          //   4544: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4547: ldc 34
          //   4549: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4552: return
          //   4553: aload_0
          //   4554: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4557: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4560: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4563: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4566: iconst_3
          //   4567: anewarray 4	java/lang/Object
          //   4570: dup
          //   4571: iconst_0
          //   4572: aload_0
          //   4573: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4576: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4579: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   4582: aastore
          //   4583: dup
          //   4584: iconst_1
          //   4585: bipush 14
          //   4587: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4590: aastore
          //   4591: dup
          //   4592: iconst_2
          //   4593: iconst_1
          //   4594: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4597: aastore
          //   4598: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4601: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4604: aload_0
          //   4605: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4608: astore_1
          //   4609: aload_1
          //   4610: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4613: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4616: ldc_w 695
          //   4619: iconst_1
          //   4620: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   4623: aload_1
          //   4624: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4627: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   4630: astore_1
          //   4631: aload_1
          //   4632: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   4635: ifne +17 -> 4652
          //   4638: ldc 77
          //   4640: ldc_w 755
          //   4643: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   4646: ldc 34
          //   4648: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4651: return
          //   4652: ldc_w 703
          //   4655: new 91	java/util/HashMap
          //   4658: dup
          //   4659: invokespecial 92	java/util/HashMap:<init>	()V
          //   4662: aload_1
          //   4663: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   4666: aload_1
          //   4667: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   4670: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   4673: astore 5
          //   4675: aload_1
          //   4676: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4679: new 125	java/lang/StringBuilder
          //   4682: dup
          //   4683: ldc 127
          //   4685: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4688: aload 5
          //   4690: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4693: ldc 136
          //   4695: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4698: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4701: aconst_null
          //   4702: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   4705: aload_1
          //   4706: getfield 704	com/tencent/mm/plugin/webview/jsapi/j:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4709: ldc_w 706
          //   4712: ldc_w 757
          //   4715: aload_1
          //   4716: getfield 709	com/tencent/mm/plugin/webview/jsapi/j:WDK	I
          //   4719: invokeinterface 713 4 0
          //   4724: ldc 34
          //   4726: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4729: return
          //   4730: astore_1
          //   4731: ldc 77
          //   4733: new 125	java/lang/StringBuilder
          //   4736: dup
          //   4737: ldc_w 715
          //   4740: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   4743: aload_1
          //   4744: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   4747: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   4750: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   4753: invokestatic 718	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   4756: ldc 34
          //   4758: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4761: return
          //   4762: aload_0
          //   4763: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4766: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4769: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   4772: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4775: iconst_3
          //   4776: anewarray 4	java/lang/Object
          //   4779: dup
          //   4780: iconst_0
          //   4781: aload_0
          //   4782: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4785: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4788: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   4791: aastore
          //   4792: dup
          //   4793: iconst_1
          //   4794: bipush 16
          //   4796: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4799: aastore
          //   4800: dup
          //   4801: iconst_2
          //   4802: iconst_1
          //   4803: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   4806: aastore
          //   4807: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   4810: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   4813: aload_0
          //   4814: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   4817: astore_1
          //   4818: new 732	android/os/Bundle
          //   4821: dup
          //   4822: invokespecial 758	android/os/Bundle:<init>	()V
          //   4825: astore 5
          //   4827: aload 5
          //   4829: ldc_w 760
          //   4832: ldc_w 762
          //   4835: invokevirtual 765	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   4838: aload_1
          //   4839: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4842: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   4845: getfield 766	com/tencent/mm/plugin/webview/core/k:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   4848: bipush 71
          //   4850: aload 5
          //   4852: invokeinterface 770 3 0
          //   4857: ldc_w 762
          //   4860: invokevirtual 774	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
          //   4863: astore 5
          //   4865: aload 5
          //   4867: ifnull +13 -> 4880
          //   4870: aload 5
          //   4872: invokevirtual 181	java/util/ArrayList:size	()I
          //   4875: istore_2
          //   4876: iload_2
          //   4877: ifgt +9 -> 4886
          //   4880: ldc 34
          //   4882: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4885: return
          //   4886: aload 5
          //   4888: invokevirtual 181	java/util/ArrayList:size	()I
          //   4891: iconst_1
          //   4892: if_icmpne +22 -> 4914
          //   4895: aload_1
          //   4896: aload 5
          //   4898: iconst_0
          //   4899: invokevirtual 185	java/util/ArrayList:get	(I)Ljava/lang/Object;
          //   4902: checkcast 187	java/lang/String
          //   4905: invokevirtual 777	com/tencent/mm/plugin/webview/ui/tools/o:blI	(Ljava/lang/String;)V
          //   4908: ldc 34
          //   4910: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   4913: return
          //   4914: aload_1
          //   4915: aload 5
          //   4917: invokevirtual 781	com/tencent/mm/plugin/webview/ui/tools/o:mj	(Ljava/util/List;)V
          //   4920: new 783	com/tencent/mm/ui/tools/l
          //   4923: dup
          //   4924: aload_1
          //   4925: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4928: invokespecial 786	com/tencent/mm/ui/tools/l:<init>	(Landroid/content/Context;)V
          //   4931: astore 6
          //   4933: aload 6
          //   4935: aload_1
          //   4936: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4939: getfield 284	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4942: aload_1
          //   4943: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4946: aconst_null
          //   4947: invokevirtual 789	com/tencent/mm/ui/tools/l:a	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/u$i;)V
          //   4950: aload 6
          //   4952: new 791	com/tencent/mm/plugin/webview/ui/tools/o$13
          //   4955: dup
          //   4956: aload_1
          //   4957: invokespecial 792	com/tencent/mm/plugin/webview/ui/tools/o$13:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   4960: putfield 796	com/tencent/mm/ui/tools/l:Vti	Lcom/tencent/mm/ui/base/u$b;
          //   4963: aload 6
          //   4965: new 798	com/tencent/mm/plugin/webview/ui/tools/o$14
          //   4968: dup
          //   4969: aload_1
          //   4970: invokespecial 799	com/tencent/mm/plugin/webview/ui/tools/o$14:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   4973: putfield 803	com/tencent/mm/ui/tools/l:Vtj	Lcom/tencent/mm/ui/base/u$d;
          //   4976: aload 6
          //   4978: aload_1
          //   4979: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   4982: getfield 284	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
          //   4985: new 805	com/tencent/mm/plugin/webview/ui/tools/o$15
          //   4988: dup
          //   4989: aload_1
          //   4990: aload 5
          //   4992: invokespecial 807	com/tencent/mm/plugin/webview/ui/tools/o$15:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Ljava/util/ArrayList;)V
          //   4995: new 809	com/tencent/mm/plugin/webview/ui/tools/o$16
          //   4998: dup
          //   4999: aload_1
          //   5000: invokespecial 810	com/tencent/mm/plugin/webview/ui/tools/o$16:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;)V
          //   5003: invokevirtual 812	com/tencent/mm/ui/tools/l:b	(Landroid/view/View;Landroid/view/View$OnCreateContextMenuListener;Lcom/tencent/mm/ui/base/u$i;)V
          //   5006: ldc 34
          //   5008: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5011: return
          //   5012: astore_1
          //   5013: ldc 162
          //   5015: new 125	java/lang/StringBuilder
          //   5018: dup
          //   5019: ldc_w 814
          //   5022: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   5025: aload_1
          //   5026: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   5029: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5032: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5035: invokestatic 718	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   5038: ldc 34
          //   5040: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5043: return
          //   5044: aload_0
          //   5045: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5048: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5051: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5054: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5057: iconst_3
          //   5058: anewarray 4	java/lang/Object
          //   5061: dup
          //   5062: iconst_0
          //   5063: aload_0
          //   5064: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5067: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5070: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   5073: aastore
          //   5074: dup
          //   5075: iconst_1
          //   5076: bipush 31
          //   5078: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5081: aastore
          //   5082: dup
          //   5083: iconst_2
          //   5084: iconst_1
          //   5085: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5088: aastore
          //   5089: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5092: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5095: aload_0
          //   5096: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5099: invokevirtual 817	com/tencent/mm/plugin/webview/ui/tools/o:cZR	()V
          //   5102: ldc 34
          //   5104: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5107: return
          //   5108: getstatic 309	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
          //   5111: ldc2_w 818
          //   5114: lconst_1
          //   5115: lconst_1
          //   5116: iconst_0
          //   5117: invokevirtual 317	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   5120: aload_0
          //   5121: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5124: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5127: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5130: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5133: iconst_3
          //   5134: anewarray 4	java/lang/Object
          //   5137: dup
          //   5138: iconst_0
          //   5139: aload_0
          //   5140: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5143: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5146: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   5149: aastore
          //   5150: dup
          //   5151: iconst_1
          //   5152: bipush 28
          //   5154: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5157: aastore
          //   5158: dup
          //   5159: iconst_2
          //   5160: iconst_1
          //   5161: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5164: aastore
          //   5165: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5168: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5171: aload_0
          //   5172: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5175: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5178: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXi	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5181: invokevirtual 828	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:isShown	()Z
          //   5184: ifne +1017 -> 6201
          //   5187: aload_0
          //   5188: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5191: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5194: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXi	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5197: invokevirtual 831	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:reset	()V
          //   5200: aload_0
          //   5201: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5204: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5207: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXi	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5210: invokevirtual 834	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:iCA	()V
          //   5213: aload_0
          //   5214: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5217: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5220: getfield 823	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WXi	Lcom/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter;
          //   5223: invokevirtual 837	com/tencent/mm/plugin/webview/ui/tools/widget/WebViewSearchContentInputFooter:show	()V
          //   5226: ldc 34
          //   5228: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5231: return
          //   5232: aload_0
          //   5233: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5236: astore_1
          //   5237: ldc 162
          //   5239: ldc_w 839
          //   5242: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   5245: aload_1
          //   5246: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5249: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   5252: ifnull +72 -> 5324
          //   5255: aload_1
          //   5256: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5259: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   5262: astore_1
          //   5263: aload_1
          //   5264: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   5267: ifne +17 -> 5284
          //   5270: ldc 77
          //   5272: ldc_w 841
          //   5275: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   5278: ldc 34
          //   5280: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5283: return
          //   5284: ldc 77
          //   5286: ldc_w 843
          //   5289: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   5292: new 845	com/tencent/mm/plugin/webview/jsapi/j$22
          //   5295: dup
          //   5296: aload_1
          //   5297: ldc_w 847
          //   5300: new 91	java/util/HashMap
          //   5303: dup
          //   5304: invokespecial 92	java/util/HashMap:<init>	()V
          //   5307: aload_1
          //   5308: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   5311: aload_1
          //   5312: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   5315: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   5318: invokespecial 850	com/tencent/mm/plugin/webview/jsapi/j$22:<init>	(Lcom/tencent/mm/plugin/webview/jsapi/j;Ljava/lang/String;)V
          //   5321: invokestatic 856	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
          //   5324: ldc 34
          //   5326: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5329: return
          //   5330: aload_0
          //   5331: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5334: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5337: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5340: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5343: iconst_3
          //   5344: anewarray 4	java/lang/Object
          //   5347: dup
          //   5348: iconst_0
          //   5349: aload_0
          //   5350: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5353: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5356: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   5359: aastore
          //   5360: dup
          //   5361: iconst_1
          //   5362: bipush 33
          //   5364: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5367: aastore
          //   5368: dup
          //   5369: iconst_2
          //   5370: iconst_1
          //   5371: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5374: aastore
          //   5375: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5378: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5381: aload_0
          //   5382: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5385: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5388: invokevirtual 859	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:iyR	()I
          //   5391: bipush 16
          //   5393: if_icmpeq +18 -> 5411
          //   5396: aload_0
          //   5397: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5400: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5403: getfield 391	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wyj	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/h;
          //   5406: iconst_0
          //   5407: invokevirtual 400	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/h:IY	(Z)Z
          //   5410: pop
          //   5411: aload_0
          //   5412: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5415: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5418: getfield 863	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WYr	Lcom/tencent/mm/plugin/webview/ui/tools/multitask/a;
          //   5421: iconst_1
          //   5422: invokevirtual 869	com/tencent/mm/plugin/webview/ui/tools/multitask/a:ke	(Z)V
          //   5425: ldc 34
          //   5427: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5430: return
          //   5431: aload_0
          //   5432: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5435: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5438: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5441: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5444: iconst_3
          //   5445: anewarray 4	java/lang/Object
          //   5448: dup
          //   5449: iconst_0
          //   5450: aload_0
          //   5451: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5454: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5457: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   5460: aastore
          //   5461: dup
          //   5462: iconst_1
          //   5463: bipush 34
          //   5465: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5468: aastore
          //   5469: dup
          //   5470: iconst_2
          //   5471: iconst_1
          //   5472: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5475: aastore
          //   5476: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5479: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5482: ldc 34
          //   5484: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5487: return
          //   5488: aload_0
          //   5489: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5492: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5495: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5498: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5501: iconst_3
          //   5502: anewarray 4	java/lang/Object
          //   5505: dup
          //   5506: iconst_0
          //   5507: aload_0
          //   5508: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5511: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5514: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   5517: aastore
          //   5518: dup
          //   5519: iconst_1
          //   5520: bipush 99
          //   5522: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5525: aastore
          //   5526: dup
          //   5527: iconst_2
          //   5528: iconst_1
          //   5529: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5532: aastore
          //   5533: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5536: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5539: aload_0
          //   5540: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5543: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5546: astore_1
          //   5547: aload_1
          //   5548: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   5551: ifnull +24 -> 5575
          //   5554: invokestatic 874	com/tencent/mm/plugin/webview/jsapi/n:itP	()Z
          //   5557: ifne +24 -> 5581
          //   5560: iconst_1
          //   5561: istore 4
          //   5563: iload 4
          //   5565: invokestatic 877	com/tencent/mm/plugin/webview/jsapi/n:ID	(Z)V
          //   5568: aload_1
          //   5569: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   5572: invokevirtual 409	com/tencent/mm/plugin/webview/core/k:reload	()V
          //   5575: ldc 34
          //   5577: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5580: return
          //   5581: iconst_0
          //   5582: istore 4
          //   5584: goto -21 -> 5563
          //   5587: aload_0
          //   5588: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5591: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5594: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   5597: ldc_w 847
          //   5600: aconst_null
          //   5601: new 879	org/json/JSONObject
          //   5604: dup
          //   5605: invokespecial 880	org/json/JSONObject:<init>	()V
          //   5608: invokevirtual 883	com/tencent/mm/plugin/webview/jsapi/j:b	(Ljava/lang/String;Ljava/util/Map;Lorg/json/JSONObject;)V
          //   5611: ldc 34
          //   5613: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5616: return
          //   5617: aload_0
          //   5618: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5621: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5624: invokevirtual 886	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getTaskId	()I
          //   5627: aconst_null
          //   5628: invokestatic 891	com/tencent/mm/ui/ag:a	(ILcom/tencent/mm/ui/ag$a;)V
          //   5631: ldc 34
          //   5633: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5636: return
          //   5637: ldc 77
          //   5639: ldc_w 893
          //   5642: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   5645: new 879	org/json/JSONObject
          //   5648: dup
          //   5649: aload 5
          //   5651: invokespecial 894	org/json/JSONObject:<init>	(Ljava/lang/String;)V
          //   5654: astore 6
          //   5656: aload 6
          //   5658: ldc 103
          //   5660: invokevirtual 898	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
          //   5663: invokevirtual 899	java/lang/Object:toString	()Ljava/lang/String;
          //   5666: astore 5
          //   5668: aload 6
          //   5670: ldc_w 901
          //   5673: invokevirtual 898	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
          //   5676: invokevirtual 899	java/lang/Object:toString	()Ljava/lang/String;
          //   5679: astore 6
          //   5681: new 91	java/util/HashMap
          //   5684: dup
          //   5685: invokespecial 92	java/util/HashMap:<init>	()V
          //   5688: astore 7
          //   5690: aload 7
          //   5692: ldc_w 901
          //   5695: aload 6
          //   5697: invokeinterface 904 3 0
          //   5702: pop
          //   5703: aload 7
          //   5705: ldc 103
          //   5707: aload 5
          //   5709: invokeinterface 904 3 0
          //   5714: pop
          //   5715: ldc_w 906
          //   5718: aload 7
          //   5720: aload_1
          //   5721: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   5724: aload_1
          //   5725: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   5728: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   5731: astore 5
          //   5733: ldc 77
          //   5735: ldc_w 908
          //   5738: aload 5
          //   5740: invokestatic 492	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   5743: invokevirtual 495	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   5746: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   5749: aload_1
          //   5750: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   5753: new 125	java/lang/StringBuilder
          //   5756: dup
          //   5757: ldc 127
          //   5759: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   5762: aload 5
          //   5764: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5767: ldc 136
          //   5769: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   5772: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5775: aconst_null
          //   5776: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   5779: ldc 34
          //   5781: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5784: return
          //   5785: astore_1
          //   5786: ldc 77
          //   5788: aload_1
          //   5789: ldc_w 418
          //   5792: iconst_0
          //   5793: anewarray 4	java/lang/Object
          //   5796: invokestatic 912	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   5799: ldc 34
          //   5801: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5804: return
          //   5805: iload_3
          //   5806: iconst_1
          //   5807: iadd
          //   5808: istore_3
          //   5809: goto -5165 -> 644
          //   5812: aload_0
          //   5813: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5816: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5819: getfield 193	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wye	Lcom/tencent/mm/plugin/webview/model/ba;
          //   5822: invokevirtual 199	com/tencent/mm/plugin/webview/model/ba:ivL	()Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5825: iconst_3
          //   5826: anewarray 4	java/lang/Object
          //   5829: dup
          //   5830: iconst_0
          //   5831: aload_0
          //   5832: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5835: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5838: invokevirtual 202	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
          //   5841: aastore
          //   5842: dup
          //   5843: iconst_1
          //   5844: bipush 16
          //   5846: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5849: aastore
          //   5850: dup
          //   5851: iconst_2
          //   5852: iconst_1
          //   5853: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   5856: aastore
          //   5857: invokevirtual 208	com/tencent/mm/plugin/webview/model/ba$d:F	([Ljava/lang/Object;)Lcom/tencent/mm/plugin/webview/model/ba$d;
          //   5860: invokevirtual 211	com/tencent/mm/plugin/webview/model/ba$d:report	()V
          //   5863: new 125	java/lang/StringBuilder
          //   5866: dup
          //   5867: invokespecial 913	java/lang/StringBuilder:<init>	()V
          //   5870: aload_1
          //   5871: invokeinterface 917 1 0
          //   5876: invokevirtual 920	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   5879: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   5882: astore 5
          //   5884: aload 5
          //   5886: invokestatic 473	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
          //   5889: ifne +312 -> 6201
          //   5892: iconst_0
          //   5893: istore_2
          //   5894: new 732	android/os/Bundle
          //   5897: dup
          //   5898: invokespecial 758	android/os/Bundle:<init>	()V
          //   5901: astore_1
          //   5902: aload_1
          //   5903: ldc_w 922
          //   5906: aload 5
          //   5908: invokevirtual 765	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
          //   5911: aload_0
          //   5912: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5915: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   5918: getfield 404	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
          //   5921: getfield 766	com/tencent/mm/plugin/webview/core/k:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   5924: bipush 50
          //   5926: aload_1
          //   5927: invokeinterface 770 3 0
          //   5932: astore_1
          //   5933: aload_1
          //   5934: ifnull +33 -> 5967
          //   5937: aload_1
          //   5938: ldc_w 924
          //   5941: invokevirtual 928	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   5944: istore_2
          //   5945: iload_2
          //   5946: iconst_2
          //   5947: if_icmpne +39 -> 5986
          //   5950: iconst_1
          //   5951: istore_2
          //   5952: aload_1
          //   5953: ldc_w 924
          //   5956: invokevirtual 928	android/os/Bundle:getInt	(Ljava/lang/String;)I
          //   5959: istore_3
          //   5960: iload_3
          //   5961: iconst_3
          //   5962: if_icmpne +29 -> 5991
          //   5965: iconst_1
          //   5966: istore_2
          //   5967: iload_2
          //   5968: ifeq +47 -> 6015
          //   5971: aload_0
          //   5972: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   5975: aload 5
          //   5977: invokevirtual 777	com/tencent/mm/plugin/webview/ui/tools/o:blI	(Ljava/lang/String;)V
          //   5980: ldc 34
          //   5982: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   5985: return
          //   5986: iconst_0
          //   5987: istore_2
          //   5988: goto -36 -> 5952
          //   5991: iconst_0
          //   5992: istore_2
          //   5993: goto -26 -> 5967
          //   5996: astore_1
          //   5997: iconst_0
          //   5998: istore_2
          //   5999: ldc 162
          //   6001: aload_1
          //   6002: ldc_w 418
          //   6005: iconst_0
          //   6006: anewarray 4	java/lang/Object
          //   6009: invokestatic 912	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   6012: goto -45 -> 5967
          //   6015: aload_0
          //   6016: getfield 21	com/tencent/mm/plugin/webview/ui/tools/o$2:WVD	Lcom/tencent/mm/plugin/webview/ui/tools/o;
          //   6019: astore_1
          //   6020: aload_1
          //   6021: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   6024: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   6027: ldc_w 695
          //   6030: iconst_0
          //   6031: invokevirtual 637	com/tencent/mm/plugin/webview/jsapi/j:dG	(Ljava/lang/String;Z)V
          //   6034: aload_1
          //   6035: invokevirtual 63	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
          //   6038: getfield 69	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:WlX	Lcom/tencent/mm/plugin/webview/jsapi/j;
          //   6041: astore_1
          //   6042: aload_1
          //   6043: getfield 75	com/tencent/mm/plugin/webview/jsapi/j:UcS	Z
          //   6046: ifne +17 -> 6063
          //   6049: ldc 77
          //   6051: ldc_w 930
          //   6054: invokestatic 85	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   6057: ldc 34
          //   6059: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   6062: return
          //   6063: new 91	java/util/HashMap
          //   6066: dup
          //   6067: invokespecial 92	java/util/HashMap:<init>	()V
          //   6070: astore 6
          //   6072: aload 6
          //   6074: ldc_w 706
          //   6077: ldc_w 932
          //   6080: invokevirtual 101	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
          //   6083: pop
          //   6084: ldc_w 703
          //   6087: aload 6
          //   6089: aload_1
          //   6090: getfield 110	com/tencent/mm/plugin/webview/jsapi/j:WDI	Z
          //   6093: aload_1
          //   6094: getfield 113	com/tencent/mm/plugin/webview/jsapi/j:KQY	Ljava/lang/String;
          //   6097: invokestatic 119	com/tencent/mm/plugin/webview/jsapi/p$a:b	(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;)Ljava/lang/String;
          //   6100: astore 6
          //   6102: aload_1
          //   6103: getfield 123	com/tencent/mm/plugin/webview/jsapi/j:WDz	Lcom/tencent/mm/ui/widget/MMWebView;
          //   6106: new 125	java/lang/StringBuilder
          //   6109: dup
          //   6110: ldc 127
          //   6112: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   6115: aload 6
          //   6117: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   6120: ldc 136
          //   6122: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   6125: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   6128: aconst_null
          //   6129: invokevirtual 146	com/tencent/mm/ui/widget/MMWebView:evaluateJavascript	(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
          //   6132: aload_1
          //   6133: getfield 704	com/tencent/mm/plugin/webview/jsapi/j:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   6136: ldc_w 934
          //   6139: aload 5
          //   6141: aload_1
          //   6142: getfield 709	com/tencent/mm/plugin/webview/jsapi/j:WDK	I
          //   6145: invokeinterface 713 4 0
          //   6150: aload_1
          //   6151: getfield 704	com/tencent/mm/plugin/webview/jsapi/j:sLC	Lcom/tencent/mm/plugin/webview/stub/e;
          //   6154: ldc_w 706
          //   6157: ldc_w 932
          //   6160: aload_1
          //   6161: getfield 709	com/tencent/mm/plugin/webview/jsapi/j:WDK	I
          //   6164: invokeinterface 713 4 0
          //   6169: ldc 34
          //   6171: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   6174: return
          //   6175: astore_1
          //   6176: ldc 77
          //   6178: new 125	java/lang/StringBuilder
          //   6181: dup
          //   6182: ldc_w 715
          //   6185: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   6188: aload_1
          //   6189: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   6192: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   6195: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   6198: invokestatic 718	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   6201: ldc 34
          //   6203: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   6206: return
          //   6207: astore_1
          //   6208: goto -209 -> 5999
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	6211	0	this	2
          //   0	6211	1	paramAnonymousMenuItem	MenuItem
          //   0	6211	2	paramAnonymousInt	int
          //   643	5320	3	i	int
          //   5561	22	4	bool	boolean
          //   37	6103	5	localObject1	Object
          //   89	6027	6	localObject2	Object
          //   2125	3594	7	localObject3	Object
          //   2132	661	8	locale	com.tencent.mm.plugin.webview.stub.e
          // Exception table:
          //   from	to	target	type
          //   2257	2271	2345	java/lang/Exception
          //   2271	2344	2345	java/lang/Exception
          //   2396	2476	2345	java/lang/Exception
          //   2477	2493	2345	java/lang/Exception
          //   2193	2203	2372	java/lang/Exception
          //   2792	2802	2880	java/lang/Exception
          //   3880	3899	3905	java/lang/Exception
          //   4705	4724	4730	java/lang/Exception
          //   4818	4865	5012	java/lang/Exception
          //   4870	4876	5012	java/lang/Exception
          //   4886	4908	5012	java/lang/Exception
          //   4914	5006	5012	java/lang/Exception
          //   5645	5779	5785	org/json/JSONException
          //   5894	5933	5996	java/lang/Exception
          //   5937	5945	5996	java/lang/Exception
          //   6132	6169	6175	java/lang/Exception
          //   5952	5960	6207	java/lang/Exception
        }
      };
      this.ucS.GAC = ((u.i)localObject2);
      this.ucS.agei = new f.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(296237);
          o.c localc = (o.c)o.this.WVm.get(Integer.valueOf(45));
          if (localc == null)
          {
            AppMethodBeat.o(296237);
            return;
          }
          o.this.WVm.remove(Integer.valueOf(45));
          int i;
          if ((o.this.ucS != null) && (o.this.ucS.isShowing()) && (o.this.WVv != null))
          {
            i = o.this.WVv.aAW(7);
            localObject = o.this.ucS;
            if ((((com.tencent.mm.ui.widget.a.f)localObject).mRecyclerView != null) && (((com.tencent.mm.ui.widget.a.f)localObject).mRecyclerView.getLayoutManager() != null) && (((com.tencent.mm.ui.widget.a.f)localObject).agfc != null))
            {
              ((com.tencent.mm.ui.widget.a.f)localObject).agfc.cag = i;
              ((com.tencent.mm.ui.widget.a.f)localObject).mRecyclerView.getLayoutManager().startSmoothScroll(((com.tencent.mm.ui.widget.a.f)localObject).agfc);
            }
          }
          Object localObject = o.this;
          if (localc != null)
          {
            i = localc.tlb;
            Bundle localBundle = localc.WVT;
            if ((localBundle != null) && (i == 45))
            {
              ResolveInfo localResolveInfo = (ResolveInfo)localBundle.getParcelable("show_browser_resolve_info");
              boolean bool = localBundle.getBoolean("show_browser_with_animation", false);
              if (localResolveInfo != null)
              {
                ((o)localObject).WVl.Xbc = null;
                ((o)localObject).WVl.qK = localResolveInfo;
                ((o)localObject).a(((o)localObject).iwO(), ((o)localObject).WVl.qK, ((o)localObject).WVv, localc.disable, bool);
              }
            }
          }
          AppMethodBeat.o(296237);
        }
      };
      this.ucS.aeLi = new f.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(296234);
          o.this.WVn.lsO = 1;
          if ((o.this.iwO().iyJ()) && (o.this.iwO().WlX != null)) {
            o.this.iwO().WlX.bB(true, false);
          }
          AppMethodBeat.o(296234);
        }
      };
      if (iwO().sLD != null) {
        break label380;
      }
      Log.e("MicroMsg.WebViewMenuHelper", "get permission failed");
      AppMethodBeat.o(296320);
      return;
      bool = false;
      break;
      this.ucS = new com.tencent.mm.ui.widget.a.f(iwO(), 0, true);
      break label161;
    }
    label380:
    Object localObject3 = iwO().iwo();
    this.ucS.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(296247);
        if (o.this.bpe())
        {
          AppMethodBeat.o(296247);
          return;
        }
        if (o.this.iwN())
        {
          AppMethodBeat.o(296247);
          return;
        }
        o.this.WVv = paramAnonymouss;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 0L, 1L, false);
        paramAnonymouss.clear();
        if (o.this.WVx.booleanValue())
        {
          j = o.this.WVw.size();
          i = 0;
          while (i < j)
          {
            localObject1 = (e.b)o.this.WVw.get(i);
            localObject2 = (t)paramAnonymouss.c(((e.b)localObject1).id, ((e.b)localObject1).title);
            ((t)localObject2).adSb = ((ContextMenu.ContextMenuInfo)localObject1);
            ((t)localObject2).setIcon(null);
            ((t)localObject2).setIcon(0);
            i += 1;
          }
          AppMethodBeat.o(296247);
          return;
        }
        if ((o.this.aur(1)) && (o.a(this.WVG, 21)) && (o.this.auq(1)))
        {
          paramAnonymouss.a(1, o.this.iwO().getString(c.i.readerapp_alert_retransmit), c.h.icons_filled_share, o.this.iwO().getResources().getColor(c.c.Brand), o.b(this.WVG, 21));
          if (!o.b(this.WVG, 21))
          {
            localObject1 = o.this;
            localObject2 = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.q.class)).iGI();
            ((o)localObject1).ucS.GAx = new o.23((o)localObject1, (com.tencent.mm.pluginsdk.q)localObject2);
            ((o)localObject1).ucS.agen = new o.24((o)localObject1, (com.tencent.mm.pluginsdk.q)localObject2);
            ((o)localObject1).ucS.ageo = new o.25((o)localObject1, (com.tencent.mm.pluginsdk.q)localObject2);
          }
        }
        if ((o.this.aur(2)) && (o.a(this.WVG, 23)) && (o.this.auq(2))) {
          paramAnonymouss.a(2, o.this.iwO().getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, 0, o.b(this.WVG, 23));
        }
        int j = -1;
        m = -1;
        i = j;
        try
        {
          localObject1 = new Bundle();
          i = j;
          ((Bundle)localObject1).putInt("WebViewShare_BinderID", o.this.iwO().Wzl.irL());
          i = j;
          ((Bundle)localObject1).putString("WebViewShare_wv_url", o.this.iwO().Wzl.sMP.getUrl());
          i = j;
          localObject1 = o.this.iwO().Wzl.sLC.m(109, (Bundle)localObject1);
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
            if (!o.this.iwO().Wzl.sLC.m(78, null).getBoolean("isOpenForFaceBook", false)) {
              break label1258;
            }
            paramAnonymouss.a(33, o.this.iwO().getString(c.i.wv_share_to_facebook), c.h.default_facebookapp, 0, o.b(this.WVG, 31));
            if ((!o.this.aur(26)) || (!o.a(this.WVG, 278)) || (!com.tencent.mm.plugin.webview.stub.a.cs(o.this.iwO(), o.this.iwO().sMP.getUrl())) || (!o.this.auq(26))) {
              break label1355;
            }
            paramAnonymouss.a(26, o.this.iwO().getString(c.i.wv_send_to_we_read), c.h.bottomsheet_icon_weread, 0, o.b(this.WVG, 278));
            if ((i == 0) || (!o.this.aur(7)) || (!o.a(this.WVG, 45)) || (!o.this.auq(7))) {
              break label1562;
            }
            bool = o.b(this.WVG, 45);
            paramAnonymouss.a(7, o.this.iwO().getString(c.i.wv_alert_open_in_browser), c.h.bottomsheet_icon_brower, o.this.iwO().getResources().getColor(c.c.Indigo), bool);
            if (o.this.WVm.containsKey(Integer.valueOf(45))) {
              break label2602;
            }
            o.this.WVl.qK = o.a(o.this.iwO(), o.this.iwO().sLC);
            Log.i("MicroMsg.WebViewMenuHelper", "alvinluo showReaderModeMenu defaultBrowser: %s", new Object[] { o.this.WVl.qK });
            if (o.this.WVl.qK == null) {
              break label1562;
            }
            o.this.a(o.this.iwO(), o.this.WVl.qK, paramAnonymouss, bool, false);
            localObject1 = o.this.iwO().getIntent().getStringExtra("sns_local_id");
            l = o.this.iwO().getIntent().getLongExtra("msg_id", -9223372036854775808L);
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
                  if ((o.this.aur(23)) && (o.this.iwO().Wzl.sLC.ak(l, (String)localObject1))) {
                    paramAnonymouss.a(23, o.this.iwO().getString(c.i.download_other_open), c.h.bottomsheet_icon_other_mode);
                  }
                  if ((i != 0) && (o.this.aur(24)) && (o.a(this.WVG, 43)) && (o.this.auq(24)) && (!com.tencent.mm.pluginsdk.model.app.u.y(o.this.iwO(), "com.tencent.wework"))) {}
                  try
                  {
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putString("enterprise_action", "enterprise_has_connector");
                    localObject1 = o.this.iwO().Wzl.sLC.m(71, (Bundle)localObject1);
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
                      o.a(o.this, localException5);
                    }
                  }
                  if (bool) {
                    paramAnonymouss.a(24, o.this.iwO().getString(c.i.readerapp_send_to_enterprise), c.h.bottomsheet_icon_enterprise, o.b(this.WVG, 43));
                  }
                  if ((o.this.aur(8)) && (o.a(this.WVG, 36)) && (o.this.auq(8))) {
                    localObject1 = null;
                  }
                  try
                  {
                    localObject2 = o.this.iwO().Wzl.sLC.iwW();
                    localObject1 = localObject2;
                  }
                  catch (Exception localException6)
                  {
                    String str;
                    o.c localc;
                    break label1876;
                  }
                  if (Util.isNullOrNil((String)localObject1)) {
                    break label2701;
                  }
                  paramAnonymouss.a(8, o.this.iwO().getString(c.i.wv_alert_send_mail), c.h.icons_filled_email, o.this.iwO().getResources().getColor(c.c.Indigo), o.b(this.WVG, 36));
                  if ((i != 0) && (o.this.aur(20)) && (o.a(this.WVG, 91)) && (com.tencent.mm.plugin.webview.stub.a.kS(o.this.iwO())) && (o.this.auq(20))) {
                    paramAnonymouss.a(20, o.this.iwO().getString(c.i.wv_share_to_qq), c.h.bottomsheet_icon_qq, 0, o.b(this.WVG, 91));
                  }
                  if ((i != 0) && (o.this.aur(22)) && (o.a(this.WVG, 133)) && (com.tencent.mm.plugin.webview.stub.a.kS(o.this.iwO())) && (o.this.auq(22))) {
                    paramAnonymouss.a(22, o.this.iwO().getString(c.i.wv_share_to_qzone), c.h.bottomsheet_icon_qzone, 0, o.b(this.WVG, 133));
                  }
                  try
                  {
                    if ((o.this.aur(0)) && (o.a(this.WVG, 43)) && (o.this.auq(0)) && (o.this.iwO().Wzl.sLC.bGN()))
                    {
                      localObject1 = o.this.iwO().Wzl.sLC.bGM();
                      localObject2 = ((List)localObject1).iterator();
                      while (((Iterator)localObject2).hasNext()) {
                        paramAnonymouss.add((String)((Iterator)localObject2).next());
                      }
                    }
                    if (!o.this.aur(27)) {
                      break label2311;
                    }
                  }
                  catch (Exception localException1)
                  {
                    Log.w("MicroMsg.WebViewMenuHelper", "builder add, ex = " + localException1.getMessage());
                  }
                  if ((o.this.iwO().WXa != null) && (o.this.iwO().WXa.getVisibility() == 0)) {
                    paramAnonymouss.a(27, o.this.iwO().getString(c.i.readerapp_finish_webview), c.h.bottomsheet_icon_exit);
                  }
                  str = o.this.iwO().bjg(o.this.iwO().Wzl.Www);
                  localObject2 = o.this.iwO().getIntent().getStringExtra("shortcut_user_name");
                  if ((!o.this.iwO().WXv) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject2)) && (o.a(this.WVG, 255)) && (o.this.auq(29)) && (o.this.aur(29))) {
                    paramAnonymouss.a(29, o.this.iwO().getString(c.i.readerapp_add_shortcut), c.h.webview_add_shortcut, o.b(this.WVG, 255));
                  }
                  o.a(o.this, paramInt, paramAnonymouss);
                  o.this.ucS.ihf();
                  AppMethodBeat.o(296247);
                  return;
                  localException2 = localException2;
                  Log.e("MicroMsg.WebViewMenuHelper", "isSetHaoKan, e = " + localException2.getMessage());
                  int k = m;
                  continue;
                  if ((o.this.auq(39)) && (k == 1))
                  {
                    paramAnonymouss.a(39, o.this.iwO().getString(c.i.readerapp_cancel_haokan), c.h.bottomsheet_icon_cancel_hao_kan, o.this.iwO().getResources().getColor(c.c.Yellow));
                    continue;
                    i = 0;
                    continue;
                    localException3 = localException3;
                    Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException3, "", new Object[0]);
                  }
                }
                localc = (o.c)o.this.WVm.get(Integer.valueOf(45));
              } while (localc == null);
              localc.disable = bool;
              localc.WVS = paramAnonymouss.size();
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
          if ((o.this.aur(38)) && (o.this.auq(38)) && (k == 0)) {
            paramAnonymouss.a(38, o.this.iwO().getString(c.i.readerapp_haokan), c.h.bottomsheet_icon_hao_kan, o.this.iwO().getResources().getColor(c.c.Yellow));
          }
        }
        else
        {
          if ((o.this.aur(3)) && ((!o.this.iwO().WXt) || ((!Util.isNullOrNil(o.this.iwO().Wzl.Www)) && (!Util.isNullOrNil(o.this.iwO().WYM)) && (!o.this.iwO().Wzl.Www.startsWith(o.this.iwO().WYM)))) && (o.a(this.WVG, 323)) && (o.this.ixW()) && (o.this.auq(3))) {
            paramAnonymouss.a(3, o.this.iwO().getString(c.i.plugin_favorite_opt), c.h.bottomsheet_icon_fav, 0, o.b(this.WVG, 323));
          }
          localObject1 = o.this.iwO().fqa();
          bool = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy((String)localObject1);
          if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJL()) && (bool) && (o.this.iwO().iul()) && (o.this.iwO().iyi() != null) && (o.a(this.WVG, 44))) {
            paramAnonymouss.a(46, o.this.iwO().getString(c.i.webview_open_in_computer), c.h.icons_outlined_colorful_handoff, 0, o.b(this.WVG, 44));
          }
          if (com.tencent.mm.kernel.b.aZP() == 0) {
            break label2577;
          }
          i = 1;
          if ((i != 0) && (o.this.aur(25)) && (o.a(this.WVG, 322)) && (WWAPIFactory.oM(o.this.iwO()).a(IWWAPI.WWAppType.aicB)) && (o.this.auq(25)))
          {
            localObject1 = WWAPIFactory.oM(o.this.iwO()).b(IWWAPI.WWAppType.aicB);
            if (!WeChatBrands.AppInfo.current().isMainland()) {
              localObject1 = o.this.iwO().getString(c.i.wecom_name);
            }
            paramAnonymouss.a(25, o.this.iwO().getString(c.i.readerapp_send_to_wework, new Object[] { localObject1 }), c.h.bottomsheet_icon_wework, 0, o.b(this.WVG, 322));
          }
          if ((i != 0) && (o.this.aur(43)) && (o.a(this.WVG, 322)) && (WWAPIFactory.oM(o.this.iwO()).a(IWWAPI.WWAppType.aicC)) && (o.this.auq(43)))
          {
            localObject1 = WWAPIFactory.oM(o.this.iwO()).b(IWWAPI.WWAppType.aicC);
            paramAnonymouss.a(43, o.this.iwO().getString(c.i.readerapp_send_to_wework, new Object[] { localObject1 }), c.h.bottomsheet_icon_wework_local, 0, o.b(this.WVG, 322));
          }
          if ((!o.this.aur(33)) || (!o.a(this.WVG, 31)) || (!o.this.auq(33))) {}
        }
      }
    };
    Object localObject4 = iwO().fqa();
    iwO();
    Object localObject1 = WebViewUIStyleHelper.blV((String)localObject4);
    int i;
    if ((com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class) != null) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).isMpUrl((String)localObject4))) {
      i = 1;
    }
    for (;;)
    {
      this.ucS.GAz = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(296249);
          if (o.this.bpe())
          {
            AppMethodBeat.o(296249);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(480L, 0L, 1L, false);
          paramAnonymouss.clear();
          if (o.this.WVx.booleanValue())
          {
            AppMethodBeat.o(296249);
            return;
          }
          Object localObject2;
          if (!paramArrayList.isEmpty())
          {
            i = 0;
            for (;;)
            {
              if (i < paramArrayList.size()) {
                try
                {
                  String str = (String)paramArrayList.get(i);
                  Log.i("MicroMsg.WebViewMenuHelper", "menuItem:".concat(String.valueOf(str)));
                  localObject2 = new JSONObject(str);
                  str = ((JSONObject)localObject2).opt("title").toString();
                  localObject2 = Base64.decode(((JSONObject)localObject2).opt("iconData").toString(), 0);
                  paramAnonymouss.a(1000, str, new BitmapDrawable(BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length)));
                  i += 1;
                }
                catch (Exception localException1)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.WebViewMenuHelper", localException1, "", new Object[0]);
                  }
                }
              }
            }
          }
          if ((o.this.iwO().WYr != null) && (o.this.iwO().WYr.cCa()) && (o.this.aur(35)) && (o.this.auq(35))) {
            paramAnonymouss.a(35, o.this.iwO().getString(c.i.readerapp_minimize), c.h.icons_outlined_multitask);
          }
          switch (o.this.iwO().WYx)
          {
          }
          try
          {
            localObject2 = o.this.iwO().iyS();
            if ((localObject2 != null) && (!o.this.iwN()))
            {
              i = 0;
              label337:
              if ((i < ((LinkedList)localObject2).size()) && (i < 8))
              {
                com.tencent.mm.k.e.a locala = (com.tencent.mm.k.e.a)((LinkedList)localObject2).get(i);
                t localt = null;
                if ("index".equals(Util.nullAsNil(locala.id))) {
                  localt = (t)paramAnonymouss.a(15, o.this.iwO().getString(c.i.webview_jd_menu_title_index), c.h.bottomsheet_icon_jd_index);
                }
                for (;;)
                {
                  if (localt != null) {
                    localt.rDm = locala.url;
                  }
                  i += 1;
                  break label337;
                  paramAnonymouss.a(40, o.this.iwO().getString(c.i.webview_tts_start), c.h.icon_outlined_talk);
                  break;
                  paramAnonymouss.a(41, o.this.iwO().getString(c.i.webview_tts_pause), c.h.icon_outlined_stoptalking);
                  break;
                  paramAnonymouss.a(42, o.this.iwO().getString(c.i.webview_tts_resume), c.h.icon_outlined_talk);
                  break;
                  if ("categories".equals(Util.nullAsNil(locala.id))) {
                    localt = (t)paramAnonymouss.a(16, o.this.iwO().getString(c.i.webview_jd_menu_title_categories), c.h.bottomsheet_icon_jd_collect_list);
                  } else if ("cart".equals(Util.nullAsNil(locala.id))) {
                    localt = (t)paramAnonymouss.a(17, o.this.iwO().getString(c.i.webview_jd_menu_title_cart), c.h.bottomsheet_icon_jd_cart);
                  } else if ("profile".equals(Util.nullAsNil(locala.id))) {
                    localt = (t)paramAnonymouss.a(18, o.this.iwO().getString(c.i.webview_jd_menu_title_profile), c.h.bottomsheet_icon_profile);
                  } else if ("member".equals(Util.nullAsNil(locala.id))) {
                    localt = (t)paramAnonymouss.a(19, o.this.iwO().getString(c.i.webview_jd_menu_title_member), c.h.bottomsheet_icon_jd_member);
                  }
                }
              }
            }
            try
            {
              bool1 = o.this.iwO().Wzl.sLC.IS((String)localObject1);
              if (bool1) {}
            }
            catch (Exception localException5)
            {
              for (;;)
              {
                boolean bool1;
                try
                {
                  Object localObject1;
                  o.this.iwO().Wzl.sLC.bls((String)localObject1);
                  if (o.this.auq(10)) {
                    paramAnonymouss.a(10, o.this.iwO().getString(c.i.biz_report_text), c.h.icons_outlined_report_problem);
                  }
                  if ((o.this.aur(6)) && (o.a(this.WVG, 44)) && (o.this.auq(6))) {
                    paramAnonymouss.a(6, o.this.iwO().getString(c.i.wv_alert_copy_link), c.h.icons_outlined_link, o.b(this.WVG, 44));
                  }
                  if ((o.this.aur(28)) && (o.this.auq(28))) {
                    paramAnonymouss.a(28, o.this.iwO().getString(c.i.webview_bottomsheet_refresh), c.h.icons_outlined_refresh);
                  }
                  if (((paramLong & 1L) == 0L) && (o.this.aur(31)) && (o.this.auq(31))) {
                    paramAnonymouss.a(31, o.this.iwO().getString(c.i.wv_search_content), c.h.actionbar_icon_dark_search);
                  }
                  if ((this.WVG.YxJ != null) && (o.this.iwO().WXt) && (!Util.isNullOrNil(o.this.iwO().Wzl.Www)) && (!Util.isNullOrNil(o.this.iwO().WYM)) && (o.this.iwO().Wzl.Www.startsWith(o.this.iwO().WYM)) && (o.this.iwO().getIntent().getBooleanExtra("key_detail_can_delete", true)) && (o.this.ixW()) && (!o.this.iwN()))
                  {
                    if ((o.this.aur(12)) && (o.this.auq(12))) {
                      paramAnonymouss.a(12, o.this.iwO().getString(c.i.favorite_add_tag_tips), c.h.bottomsheet_icon_addtag);
                    }
                    if (o.this.aur(9)) {
                      paramAnonymouss.a(9, o.this.iwO().getString(c.i.app_delete), c.h.bottomsheet_icon_del);
                    }
                  }
                  if (o.this.iwO().Wyi.WZm.irx()) {
                    break label1835;
                  }
                  Log.i("MicroMsg.WebViewMenuHelper", "control close");
                  if (!o.this.aur(37)) {
                    break label1830;
                  }
                  o.this.iwO();
                  if ((!com.tencent.mm.plugin.webview.q.b(o.this.iwO().sMP)) || (!o.this.auq(37))) {
                    break label1830;
                  }
                  i = 1;
                  if (i != 0)
                  {
                    if ((com.tencent.mm.plugin.webview.n)o.this.iwO().Wyi.WZm.WvE.getValue() != com.tencent.mm.plugin.webview.n.Wvr) {
                      break label1869;
                    }
                    paramAnonymouss.a(37, o.this.iwO().getString(c.i.webview_menu_tranlate_revert), c.h.icons_outlined_stoptranslate);
                    o.this.iwO().Wyi.WZm.a(com.tencent.mm.plugin.webview.l.Wvg, m.Wvn);
                  }
                  if (((paramLong & 0x2) == 0L) && (o.this.aur(11)) && (o.a(this.WVG, 18)) && (o.this.auq(11))) {
                    paramAnonymouss.a(11, o.this.iwO().getString(c.i.readerapp_alert_font), c.h.icons_outlined_font, o.b(this.WVG, 18));
                  }
                  if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zlr, 0) == 1))
                  {
                    localObject1 = o.this.iwO();
                    if (!com.tencent.mm.plugin.webview.jsapi.n.itP()) {
                      break label1917;
                    }
                    i = c.i.webview_menu_disable_debug;
                    paramAnonymouss.a(99, ((WebViewUI)localObject1).getString(i), c.h.webview_menu_enable_debug, false);
                  }
                  o.a(o.this, this.WVH, paramAnonymouss);
                  o.this.ucS.ihf();
                  AppMethodBeat.o(296249);
                  return;
                  localException5 = localException5;
                  Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail isBizContact, ex = " + localException5.getMessage());
                  bool1 = false;
                }
                catch (Exception localException3)
                {
                  Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail triggerGetContact, ex = " + localException3.getMessage());
                  continue;
                }
                boolean bool2;
                try
                {
                  bool1 = o.this.iwO().Wzl.sLC.IR(localException3);
                  if (bool1)
                  {
                    bool1 = o.a(this.WVG, 19);
                    bool2 = o.b(this.WVG, 19);
                    boolean bool3 = o.this.iwO().Wzl.isx();
                    if ((!o.this.aur(5)) || (!bool1) || (!o.this.auq(5))) {
                      continue;
                    }
                    if (!bool3) {
                      break label1786;
                    }
                    paramAnonymouss.a(5, o.this.iwO().getString(c.i.wv_alert_show_subbiz_info), c.h.icons_outlined_official_accounts, bool2);
                  }
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.WebViewMenuHelper", "sharebtn click fail, ex = " + localException4.getMessage());
                    bool1 = false;
                    continue;
                    bool1 = o.a(this.WVG, 20);
                    bool2 = o.b(this.WVG, 20);
                  }
                }
                if ((this.WVI == null) || (!this.WVI.WOH))
                {
                  paramAnonymouss.a(5, o.this.iwO().getString(c.i.wv_alert_show_biz_info), c.h.icons_outlined_official_accounts, bool2);
                  continue;
                  i = 0;
                  continue;
                  if ((o.this.aur(37)) && (o.this.auq(37)))
                  {
                    i = 1;
                  }
                  else
                  {
                    i = 0;
                    continue;
                    paramAnonymouss.a(37, o.this.iwO().getString(c.i.webview_menu_tranlate), c.h.icons_outlined_translate);
                    o.this.iwO().Wyi.WZm.a(com.tencent.mm.plugin.webview.l.Wvg, m.Wvl);
                    continue;
                    i = c.i.webview_menu_enable_debug;
                  }
                }
              }
            }
          }
          catch (Exception localException2)
          {
            Log.e("MicroMsg.WebViewMenuHelper", "exception in add jd menu, " + localException2.getMessage());
            localObject1 = o.this.iwO().getIntent().getStringExtra("srcUsername");
            if (Util.isNullOrNil((String)localObject1)) {}
          }
        }
      };
      this.ucS.agem = ((u.i)localObject2);
      if ((!this.WVq) && (!paramBoolean2))
      {
        paramArrayList = iwO().fqa();
        if (Util.isNullOrNil(paramArrayList)) {
          break label1045;
        }
        localObject2 = Uri.parse(paramArrayList).getHost();
        localObject3 = iwO().getString(c.i.webview_logo_url, new Object[] { localObject2 });
        if (!Util.isNullOrNil(this.WVo)) {
          break label869;
        }
        if ((i != 0) && (localObject1 != null) && (((WebViewUIStyleHelper.a)localObject1).isDataValid()))
        {
          paramArrayList = LayoutInflater.from(iwO()).inflate(c.g.mm_webview_ui_bottom_sheet_title_brand, null);
          this.tss = paramArrayList;
          localObject2 = (ImageView)paramArrayList.findViewById(c.f.iv_head_img);
          localObject4 = (TextView)paramArrayList.findViewById(c.f.tv_nick_name);
          localObject3 = paramArrayList.findViewById(c.f.content_layout);
          ((TextView)localObject4).setText(((WebViewUIStyleHelper.a)localObject1).WZE);
          localObject4 = new com.tencent.mm.modelimage.loader.a.c.a();
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject4).oKo = true;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject4).nrc = true;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject4).oKB = c.e.default_avatar;
          com.tencent.mm.modelimage.loader.a.bKl().a(((WebViewUIStyleHelper.a)localObject1).WZF, (ImageView)localObject2, ((com.tencent.mm.modelimage.loader.a.c.a)localObject4).bKx());
          ((View)localObject3).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(296231);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              o.this.ie("Contact_Scene", 173);
              o.this.iwO().Wye.ivL().F(new Object[] { o.this.iwO().dgY(), Integer.valueOf(38), Integer.valueOf(1) }).report();
              o.this.iwO().blQ(this.WVI.owR);
              if (o.this.ucS != null) {
                o.this.ucS.cyW();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(296231);
            }
          });
          com.tencent.mm.ui.tools.o.F((View)localObject3, 0.7F);
          this.ucS.af(paramArrayList, true);
        }
      }
      else
      {
        label719:
        if ((!this.WVq) && (!iwO().iyJ())) {
          break label1060;
        }
        this.ucS.sRy = true;
        this.ucS.sRz = true;
        com.tencent.threadpool.h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(296218);
            if (o.this.iwO().WlX != null) {
              o.this.iwO().WlX.bB(false, false);
            }
            AppMethodBeat.o(296218);
          }
        }, 500L);
        label772:
        if ((iwO().WXi == null) || (!iwO().WXi.isShown())) {
          break label1079;
        }
        iwO().WXi.hide();
      }
      try
      {
        for (;;)
        {
          this.ucS.dDn();
          if (iwO().WlX != null) {
            iwO().WlX.bjN("");
          }
          AppMethodBeat.o(296320);
          return;
          i = 0;
          break;
          if (Util.isNullOrNil((String)localObject2)) {
            break label719;
          }
          this.ucS.h((CharSequence)localObject3, 1, 0);
          break label719;
          label869:
          localObject2 = LayoutInflater.from(iwO()).inflate(c.g.mm_webview_ui_bottom_sheet_title_text, null);
          this.tss = ((View)localObject2);
          localObject1 = (MMNeat7extView)((View)localObject2).findViewById(c.f.desc_text);
          this.ucS.af((View)localObject2, false);
          localObject2 = p.j(((MMNeat7extView)localObject1).getContext(), Util.nullAsNil(this.WVo), (int)((MMNeat7extView)localObject1).getTextSize());
          ((MMNeat7extView)localObject1).aZ((CharSequence)localObject2);
          localObject2 = (ClickableSpan[])((SpannableString)localObject2).getSpans(0, ((SpannableString)localObject2).length(), ClickableSpan.class);
          if ((localObject2 == null) || (localObject2.length <= 0)) {
            break label719;
          }
          Log.i("MicroMsg.WebViewMenuHelper", "terry h5 apply show");
          com.tencent.mm.plugin.report.service.h.OAn.b(16337, new Object[] { paramArrayList, Integer.valueOf(1), Integer.valueOf(0) });
          ((MMNeat7extView)localObject1).setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.l((NeatTextView)localObject1, new com.tencent.mm.pluginsdk.ui.span.s(((MMNeat7extView)localObject1).getContext()))
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(296225);
              boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
              if (bool)
              {
                Log.i("MMNeatTouchListener", "terry h5 apply click");
                com.tencent.mm.plugin.report.service.h.OAn.b(16337, new Object[] { paramArrayList, Integer.valueOf(1), Integer.valueOf(1) });
              }
              AppMethodBeat.o(296225);
              return bool;
            }
          });
          break label719;
          label1045:
          this.ucS.h(" ", 1, 0);
          break label719;
          label1060:
          this.ucS.sRy = false;
          this.ucS.sRz = false;
          break label772;
          label1079:
          iwO().hideVKB();
        }
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          Log.e("MicroMsg.WebViewMenuHelper", "tryShow ex %s", new Object[] { paramArrayList.getMessage() });
        }
      }
    }
  }
  
  final void a(com.tencent.mm.plugin.appbrand.service.j paramj)
  {
    AppMethodBeat.i(296289);
    if (this.WVz == null)
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, openMaterialCollection is null");
      AppMethodBeat.o(296289);
      return;
    }
    if (this.ucS == null)
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, mmBottomSheet is null");
      AppMethodBeat.o(296289);
      return;
    }
    WebViewUI localWebViewUI = iwO();
    if (localWebViewUI == null)
    {
      Log.w("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, webViewUI is null");
      AppMethodBeat.o(296289);
      return;
    }
    if (!paramj.a(this.ucS, this.WVz))
    {
      Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, not need enhance");
      AppMethodBeat.o(296289);
      return;
    }
    boolean bool = ixM();
    Log.i("MicroMsg.WebViewMenuHelper", "enhanceBottomSheet, canShowOpenMaterials: ".concat(String.valueOf(bool)));
    Object localObject;
    if (this.WVA != null)
    {
      localObject = this.WVA;
      if (bool) {}
      for (paramj = i.a.trv;; paramj = i.a.trx)
      {
        ((com.tencent.mm.plugin.appbrand.openmaterial.i)localObject).a(paramj);
        AppMethodBeat.o(296289);
        return;
      }
    }
    if (bool)
    {
      this.WVA = paramj.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.trW, localWebViewUI, this.ucS, this.WVz, null, null);
      localObject = this.WVB;
      paramj = (com.tencent.mm.plugin.appbrand.service.j)localObject;
      if (localObject == null)
      {
        paramj = new b();
        this.WVB = paramj;
      }
      paramj.a(localWebViewUI);
    }
    AppMethodBeat.o(296289);
  }
  
  final void a(WebViewUI paramWebViewUI, ResolveInfo paramResolveInfo, final com.tencent.mm.ui.base.s params, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(296327);
    String str1 = com.tencent.mm.plugin.webview.ui.tools.browser.b.b(paramWebViewUI, paramResolveInfo);
    final String str2 = String.format(paramWebViewUI.getString(c.i.webview_browser_open_title), new Object[] { str1 });
    if (this.WVl.Xbc != null)
    {
      a(params, str2, this.WVl.Xbc, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(296327);
      return;
    }
    new com.tencent.mm.plugin.webview.ui.tools.browser.e(paramWebViewUI, str1, new com.tencent.mm.plugin.webview.ui.tools.browser.e.a()
    {
      public final void R(Drawable paramAnonymousDrawable)
      {
        AppMethodBeat.i(296161);
        o.this.WVl.Xbc = paramAnonymousDrawable;
        if ((paramAnonymousDrawable != null) && (o.this.ucS != null) && (o.this.ucS.isShowing())) {
          o.this.a(params, str2, paramAnonymousDrawable, paramBoolean1, paramBoolean2);
        }
        AppMethodBeat.o(296161);
      }
    }).execute(new ResolveInfo[] { paramResolveInfo });
    AppMethodBeat.o(296327);
  }
  
  final void a(final com.tencent.mm.ui.base.s params, final String paramString, final Drawable paramDrawable, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(296334);
    Log.d("MicroMsg.WebViewMenuHelper", "alvinluo addDefaultBrowserMenuItem withAnimation: %s, title: %s, iconDrawable: %s, bitmap: %s", new Object[] { Boolean.valueOf(paramBoolean2), paramString, paramDrawable, null });
    if (this.ucS == null)
    {
      AppMethodBeat.o(296334);
      return;
    }
    if (!paramBoolean2)
    {
      if (a(params, Math.max(0, params.aAW(7)), paramDrawable, paramString, paramBoolean1)) {
        this.ucS.ihf();
      }
      AppMethodBeat.o(296334);
      return;
    }
    com.tencent.threadpool.h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296163);
        if ((o.this.ucS != null) && (o.this.ucS.isShowing()))
        {
          int i = Math.max(0, params.aAW(7));
          if (o.a(params, i, paramDrawable, paramString, paramBoolean1))
          {
            com.tencent.mm.ui.widget.a.f localf = o.this.ucS;
            int j = localf.Vtk.size();
            if ((localf.ageH != null) && (i >= 0) && (i < j)) {
              localf.ageH.fW(i);
            }
          }
        }
        AppMethodBeat.o(296163);
      }
    }, 100L);
    AppMethodBeat.o(296334);
  }
  
  protected final boolean a(JsapiPermissionWrapper paramJsapiPermissionWrapper, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79902);
    if (paramJsapiPermissionWrapper == null)
    {
      AppMethodBeat.o(79902);
      return false;
    }
    if ((paramJsapiPermissionWrapper.axr(paramInt1) == 1) && (auq(paramInt2)))
    {
      AppMethodBeat.o(79902);
      return true;
    }
    AppMethodBeat.o(79902);
    return false;
  }
  
  public final void aNr()
  {
    AppMethodBeat.i(79885);
    if (ixP()) {
      ixS();
    }
    AppMethodBeat.o(79885);
  }
  
  protected final boolean auq(int paramInt)
  {
    AppMethodBeat.i(79881);
    SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)this.WVh.get(iwO().sMP.getUrl());
    if ((localSparseBooleanArray != null) && (localSparseBooleanArray.get(paramInt, false)))
    {
      AppMethodBeat.o(79881);
      return false;
    }
    AppMethodBeat.o(79881);
    return true;
  }
  
  final boolean aur(int paramInt)
  {
    AppMethodBeat.i(296278);
    if (iwN())
    {
      if ((paramInt != 6) && (paramInt != 10))
      {
        AppMethodBeat.o(296278);
        return false;
      }
      AppMethodBeat.o(296278);
      return true;
    }
    if ((!this.WVr) || (this.WVt.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(296278);
      return true;
    }
    AppMethodBeat.o(296278);
    return false;
  }
  
  final void blI(String paramString)
  {
    AppMethodBeat.i(79889);
    iwO().WlX.dG("sendAppMessage", false);
    com.tencent.mm.plugin.webview.jsapi.j localj = iwO().WlX;
    if (!localj.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
      AppMethodBeat.o(79889);
      return;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("scene", "enterprise");
    localObject = p.a.b("menu:share:appmessage", (Map)localObject, localj.WDI, localj.KQY);
    localj.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    try
    {
      localj.sLC.aI("connector_local_send", paramString, localj.WDK);
      localj.sLC.aI("scene", "enterprise", localj.WDK);
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
  protected final void blJ(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1412
    //   3: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 636	com/tencent/mm/plugin/webview/ui/tools/a:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   10: invokevirtual 640	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getIntent	()Landroid/content/Intent;
    //   13: ldc_w 642
    //   16: invokevirtual 647	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   25: invokevirtual 241	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:fqa	()Ljava/lang/String;
    //   28: astore 8
    //   30: aconst_null
    //   31: astore 4
    //   33: aload 8
    //   35: invokestatic 534	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   38: ifne +13 -> 51
    //   41: aload 8
    //   43: invokestatic 780	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: invokevirtual 1087	android/net/Uri:getHost	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload 4
    //   53: invokestatic 534	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   56: ifne +526 -> 582
    //   59: aload 4
    //   61: getstatic 1415	com/tencent/mm/plugin/webview/c$i:host_mp_weixin_qq_com	I
    //   64: invokestatic 1420	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
    //   67: invokevirtual 1423	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +512 -> 582
    //   73: getstatic 1428	com/tencent/mm/ui/f$f:adwg	Ljava/lang/String;
    //   76: iconst_1
    //   77: anewarray 271	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload 8
    //   84: ldc_w 770
    //   87: invokestatic 635	com/tencent/mm/compatible/util/r:as	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 1331	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: astore 4
    //   96: aload_0
    //   97: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   100: aload_0
    //   101: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   104: getfield 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   107: invokevirtual 540	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   110: invokevirtual 604	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:bjg	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 9
    //   115: ldc_w 267
    //   118: ldc_w 1430
    //   121: iconst_1
    //   122: anewarray 271	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: getstatic 1433	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   130: aastore
    //   131: invokestatic 573	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload 9
    //   136: invokestatic 610	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +177 -> 316
    //   142: aload_0
    //   143: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   146: getfield 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   149: invokevirtual 540	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   152: invokestatic 610	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +161 -> 316
    //   158: invokestatic 618	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   161: lstore_2
    //   162: ldc_w 267
    //   165: ldc_w 1435
    //   168: bipush 7
    //   170: anewarray 271	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: sipush 13377
    //   178: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: lload_2
    //   185: invokestatic 625	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: aload 9
    //   193: aastore
    //   194: dup
    //   195: iconst_3
    //   196: aload_0
    //   197: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   200: getfield 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   203: invokevirtual 540	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_4
    //   209: aload_0
    //   210: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   213: getfield 628	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   216: aastore
    //   217: dup
    //   218: iconst_5
    //   219: iconst_4
    //   220: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: bipush 6
    //   227: iconst_1
    //   228: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 573	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: ldc 172
    //   237: astore 5
    //   239: aload_0
    //   240: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   243: getfield 537	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sMP	Lcom/tencent/mm/ui/widget/MMWebView;
    //   246: invokevirtual 540	com/tencent/mm/ui/widget/MMWebView:getUrl	()Ljava/lang/String;
    //   249: ldc_w 630
    //   252: invokestatic 635	com/tencent/mm/compatible/util/r:as	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   255: astore 6
    //   257: aload 6
    //   259: astore 5
    //   261: getstatic 657	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   264: sipush 13377
    //   267: bipush 6
    //   269: anewarray 271	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: lload_2
    //   275: invokestatic 625	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload 9
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload 5
    //   288: aastore
    //   289: dup
    //   290: iconst_3
    //   291: aload_0
    //   292: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   295: getfield 628	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:sessionId	Ljava/lang/String;
    //   298: aastore
    //   299: dup
    //   300: iconst_4
    //   301: iconst_4
    //   302: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   305: aastore
    //   306: dup
    //   307: iconst_5
    //   308: iconst_1
    //   309: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: aastore
    //   313: invokevirtual 660	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   316: aload 4
    //   318: astore 5
    //   320: aload 4
    //   322: invokestatic 534	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   325: ifeq +23 -> 348
    //   328: getstatic 1438	com/tencent/mm/ui/f$f:adwf	Ljava/lang/String;
    //   331: iconst_1
    //   332: anewarray 271	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: bipush 34
    //   339: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 1331	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   346: astore 5
    //   348: new 644	android/content/Intent
    //   351: dup
    //   352: invokespecial 1439	android/content/Intent:<init>	()V
    //   355: astore 4
    //   357: aload_1
    //   358: invokestatic 534	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   361: ifne +24 -> 385
    //   364: aload 4
    //   366: ldc_w 1441
    //   369: aload_1
    //   370: ldc_w 630
    //   373: invokevirtual 1445	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   376: bipush 11
    //   378: invokestatic 1451	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   381: invokevirtual 1455	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   384: pop
    //   385: ldc_w 267
    //   388: ldc_w 1457
    //   391: iconst_2
    //   392: anewarray 271	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload 8
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: aload_0
    //   403: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   406: invokevirtual 766	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
    //   409: aastore
    //   410: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: aload 4
    //   415: ldc_w 1459
    //   418: aload 5
    //   420: invokevirtual 1455	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   423: pop
    //   424: aload 4
    //   426: ldc_w 1461
    //   429: aload 8
    //   431: invokevirtual 1455	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   434: pop
    //   435: aload 4
    //   437: ldc_w 1463
    //   440: aload_0
    //   441: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   444: invokevirtual 766	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:dgY	()Ljava/lang/String;
    //   447: invokevirtual 1455	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   450: pop
    //   451: aload 4
    //   453: ldc_w 1465
    //   456: aload_0
    //   457: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   460: aload 7
    //   462: invokevirtual 651	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:avS	(Ljava/lang/String;)I
    //   465: invokevirtual 1468	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   468: pop
    //   469: aload 4
    //   471: ldc_w 1470
    //   474: iconst_1
    //   475: invokevirtual 1473	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   478: pop
    //   479: aload 4
    //   481: ldc_w 1475
    //   484: aload_0
    //   485: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   488: getfield 297	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:Wzl	Lcom/tencent/mm/plugin/webview/core/k;
    //   491: invokevirtual 1479	com/tencent/mm/plugin/webview/core/k:irI	()Lcom/tencent/mm/plugin/webview/e/c;
    //   494: getfield 1484	com/tencent/mm/plugin/webview/e/c:WOQ	I
    //   497: invokevirtual 1468	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   500: pop
    //   501: aload_0
    //   502: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   505: aload_0
    //   506: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   509: getstatic 1487	com/tencent/mm/plugin/webview/c$i:webview_report_screenshot_alert	I
    //   512: invokevirtual 316	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   515: ldc 172
    //   517: aload_0
    //   518: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   521: getstatic 1490	com/tencent/mm/plugin/webview/c$i:app_agree	I
    //   524: invokevirtual 316	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   527: aload_0
    //   528: invokevirtual 293	com/tencent/mm/plugin/webview/ui/tools/o:iwO	()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;
    //   531: getstatic 1493	com/tencent/mm/plugin/webview/c$i:app_disagree	I
    //   534: invokevirtual 316	com/tencent/mm/plugin/webview/ui/tools/WebViewUI:getString	(I)Ljava/lang/String;
    //   537: iconst_0
    //   538: new 22	com/tencent/mm/plugin/webview/ui/tools/o$17
    //   541: dup
    //   542: aload_0
    //   543: aload 4
    //   545: invokespecial 1496	com/tencent/mm/plugin/webview/ui/tools/o$17:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/content/Intent;)V
    //   548: new 24	com/tencent/mm/plugin/webview/ui/tools/o$18
    //   551: dup
    //   552: aload_0
    //   553: aload 4
    //   555: invokespecial 1497	com/tencent/mm/plugin/webview/ui/tools/o$18:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/o;Landroid/content/Intent;)V
    //   558: invokestatic 1500	com/tencent/mm/ui/base/k:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/e;
    //   561: pop
    //   562: ldc_w 1412
    //   565: invokestatic 227	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   568: return
    //   569: astore 4
    //   571: ldc_w 267
    //   574: aload 4
    //   576: invokevirtual 1501	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   579: invokestatic 840	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aconst_null
    //   583: astore 4
    //   585: goto -489 -> 96
    //   588: astore 6
    //   590: ldc_w 267
    //   593: aload 6
    //   595: ldc 172
    //   597: iconst_0
    //   598: anewarray 271	java/lang/Object
    //   601: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   604: goto -343 -> 261
    //   607: astore_1
    //   608: ldc_w 267
    //   611: new 439	java/lang/StringBuilder
    //   614: dup
    //   615: ldc_w 1503
    //   618: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   621: aload_1
    //   622: invokevirtual 1501	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   625: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 452	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 840	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: goto -249 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	637	0	this	o
    //   0	637	1	paramString	String
    //   161	114	2	l	long
    //   31	523	4	localObject1	Object
    //   569	6	4	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   583	1	4	localObject2	Object
    //   237	182	5	localObject3	Object
    //   255	3	6	str1	String
    //   588	6	6	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   19	442	7	str2	String
    //   28	402	8	str3	String
    //   113	169	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   73	96	569	java/io/UnsupportedEncodingException
    //   239	257	588	java/io/UnsupportedEncodingException
    //   364	385	607	java/io/UnsupportedEncodingException
  }
  
  protected final void cZR()
  {
    AppMethodBeat.i(79897);
    String str1 = iwO().bjg(iwO().Wzl.Www);
    String str2 = iwO().getIntent().getStringExtra("shortcut_user_name");
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
      iwO().Wzl.sLC.m(80, localBundle);
      AppMethodBeat.o(79897);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebViewMenuHelper", "addShortcut, e = " + localException.getMessage());
      AppMethodBeat.o(79897);
    }
  }
  
  public final void h(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(296243);
    SparseBooleanArray localSparseBooleanArray2 = (SparseBooleanArray)this.WVh.get(paramString);
    SparseBooleanArray localSparseBooleanArray1 = localSparseBooleanArray2;
    if (localSparseBooleanArray2 == null)
    {
      localSparseBooleanArray1 = new SparseBooleanArray();
      this.WVh.put(paramString, localSparseBooleanArray1);
    }
    if (localSparseBooleanArray1 != null)
    {
      localSparseBooleanArray1.put(34, true);
      localSparseBooleanArray1.put(10, paramIntent.getBooleanExtra("key_menu_hide_expose", false));
    }
    AppMethodBeat.o(296243);
  }
  
  public final void ie(String paramString, int paramInt)
  {
    AppMethodBeat.i(79895);
    if (iwO().WlX != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(paramString, paramInt);
      paramString = iwO().WlX;
      try
      {
        paramString.sLC.a(21, localBundle, paramString.WDK);
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
  
  final boolean iwN()
  {
    AppMethodBeat.i(296271);
    WebViewUI localWebViewUI = iwO();
    if ((localWebViewUI != null) && (localWebViewUI.WXf.WQY))
    {
      AppMethodBeat.o(296271);
      return true;
    }
    AppMethodBeat.o(296271);
    return false;
  }
  
  final void ixN()
  {
    AppMethodBeat.i(296232);
    if (this.ucS != null)
    {
      if (this.ucS.isShowing()) {
        this.ucS.cyW();
      }
      this.ucS.jHK();
      this.ucS = null;
    }
    this.tss = null;
    this.WVv = null;
    AppMethodBeat.o(296232);
  }
  
  public final void ixO()
  {
    AppMethodBeat.i(79879);
    this.WVi.clear();
    this.WVi.put("menuItem:share:brand", Integer.valueOf(0));
    this.WVi.put("menuItem:share:appMessage", Integer.valueOf(1));
    this.WVi.put("menuItem:share:dataMessage", Integer.valueOf(23));
    this.WVi.put("menuItem:share:timeline", Integer.valueOf(2));
    this.WVi.put("menuItem:favorite", Integer.valueOf(3));
    this.WVi.put("menuItem:profile", Integer.valueOf(5));
    this.WVi.put("menuItem:addContact", Integer.valueOf(5));
    this.WVi.put("menuItem:copyUrl", Integer.valueOf(6));
    this.WVi.put("menuItem:openWithSafari", Integer.valueOf(7));
    this.WVi.put("menuItem:share:email", Integer.valueOf(8));
    this.WVi.put("menuItem:delete", Integer.valueOf(9));
    this.WVi.put("menuItem:exposeArticle", Integer.valueOf(10));
    this.WVi.put("menuItem:setFont", Integer.valueOf(11));
    this.WVi.put("menuItem:editTag", Integer.valueOf(12));
    this.WVi.put("menuItem:share:qq", Integer.valueOf(20));
    this.WVi.put("menuItem:share:weiboApp", Integer.valueOf(21));
    this.WVi.put("menuItem:share:QZone", Integer.valueOf(22));
    this.WVi.put("menuItem:share:facebook", Integer.valueOf(33));
    this.WVi.put("menuItem:share:enterprise", Integer.valueOf(24));
    this.WVi.put("menuItem:refresh", Integer.valueOf(28));
    this.WVi.put("menuItem:share:wework", Integer.valueOf(25));
    this.WVi.put("menuItem:share:wework_LOCAL", Integer.valueOf(43));
    this.WVi.put("menuItem:share:weread", Integer.valueOf(26));
    this.WVi.put("menuItem:addShortcut", Integer.valueOf(29));
    this.WVi.put("menuItem:search", Integer.valueOf(31));
    this.WVi.put("menuItem:readArticle", Integer.valueOf(34));
    this.WVi.put("menuItem:minimize", Integer.valueOf(35));
    this.WVi.put("menuItem:cancelMinimize", Integer.valueOf(36));
    this.WVi.put("menuItem:translate", Integer.valueOf(37));
    this.WVi.put("menuItem:haoKan", Integer.valueOf(38));
    this.WVi.put("menuItem:cancelHaoKan", Integer.valueOf(39));
    this.WVi.put("menuItem:ttsStart", Integer.valueOf(40));
    this.WVi.put("menuItem:ttsPause", Integer.valueOf(41));
    this.WVi.put("menuItem:ttsResume", Integer.valueOf(42));
    AppMethodBeat.o(79879);
  }
  
  public final boolean ixP()
  {
    AppMethodBeat.i(296252);
    if (this.ucS == null)
    {
      AppMethodBeat.o(296252);
      return false;
    }
    boolean bool = this.ucS.isShowing();
    AppMethodBeat.o(296252);
    return bool;
  }
  
  protected final void ixQ()
  {
    AppMethodBeat.i(79884);
    if (!this.WVs)
    {
      AppMethodBeat.o(79884);
      return;
    }
    this.WVr = false;
    iwO().WYI = false;
    this.WVs = false;
    if (ixP()) {
      ixS();
    }
    AppMethodBeat.o(79884);
  }
  
  public final void ixR()
  {
    AppMethodBeat.i(79886);
    this.WVr = true;
    this.WVt.clear();
    if ((iwO() instanceof GameWebViewUI))
    {
      this.WVt.add(Integer.valueOf(11));
      this.WVt.add(Integer.valueOf(28));
      AppMethodBeat.o(79886);
      return;
    }
    this.WVt.add(Integer.valueOf(7));
    this.WVt.add(Integer.valueOf(11));
    this.WVt.add(Integer.valueOf(28));
    AppMethodBeat.o(79886);
  }
  
  public final void ixS()
  {
    AppMethodBeat.i(79887);
    a(0L, new ArrayList(), false, false, -1);
    AppMethodBeat.o(79887);
  }
  
  protected final void ixU()
  {
    AppMethodBeat.i(79892);
    if (iwO().WlX != null)
    {
      iwO().WlX.bjN("fav");
      iwO().WlX.dG("sendAppMessage", false);
      iwO().WlX.d(ixV(), 0);
      AppMethodBeat.o(79892);
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("msg_id", iwO().getIntent().getLongExtra("msg_id", -9223372036854775808L));
    ((Bundle)localObject1).putString("sns_local_id", iwO().getIntent().getStringExtra("sns_local_id"));
    ((Bundle)localObject1).putInt("news_svr_id", iwO().getIntent().getIntExtra("news_svr_id", 0));
    ((Bundle)localObject1).putString("news_svr_tweetid", iwO().getIntent().getStringExtra("news_svr_tweetid"));
    ((Bundle)localObject1).putInt("message_index", iwO().getIntent().getIntExtra("message_index", 0));
    ((Bundle)localObject1).putString("rawUrl", iwO().dgY());
    Object localObject2;
    if ((!Util.isNullOrNil(iwO().dgY())) && (iwO().dgY().endsWith("#rd")))
    {
      localObject2 = iwO().dgY().substring(0, iwO().dgY().length() - 3);
      if ((!Util.isNullOrNil(iwO().Wzl.Www)) && (!iwO().Wzl.Www.startsWith((String)localObject2)))
      {
        ((Bundle)localObject1).putString("rawUrl", iwO().Wzl.Www);
        ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      localObject2 = iwO().getIntent();
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("preChatName", ((Intent)localObject2).getStringExtra("preChatName"));
        ((Bundle)localObject1).putInt("preMsgIndex", ((Intent)localObject2).getIntExtra("preMsgIndex", 0));
        ((Bundle)localObject1).putString("prePublishId", ((Intent)localObject2).getStringExtra("prePublishId"));
        ((Bundle)localObject1).putString("preUsername", ((Intent)localObject2).getStringExtra("preUsername"));
      }
      try
      {
        localObject1 = iwO().Wzl.sLC.by((Bundle)localObject1);
        if (((com.tencent.mm.plugin.webview.stub.c)localObject1).iwQ())
        {
          iwO().WlX.dG("sendAppMessage", false);
          iwO().WlX.d(ixV(), 0);
          Log.i("MicroMsg.WebViewMenuHelper", "on favorite simple url");
          AppMethodBeat.o(79892);
          return;
          if ((!Util.isNullOrNil(iwO().Wzl.Www)) && (!iwO().Wzl.Www.startsWith(iwO().dgY())))
          {
            ((Bundle)localObject1).putString("rawUrl", iwO().Wzl.Www);
            ((Bundle)localObject1).putLong("msg_id", -9223372036854775808L);
          }
        }
        else
        {
          com.tencent.mm.plugin.fav.ui.e.a(((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet(), iwO(), iwO().IvJ);
          if (((com.tencent.mm.plugin.webview.stub.c)localObject1).getRet() == 0)
          {
            aus(1);
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
    aus(2);
    AppMethodBeat.o(79892);
  }
  
  public final HashMap<String, String> ixV()
  {
    AppMethodBeat.i(79893);
    if (!iwO().WYI)
    {
      AppMethodBeat.o(79893);
      return null;
    }
    Intent localIntent = iwO().getIntent();
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
  
  final boolean ixW()
  {
    AppMethodBeat.i(79896);
    try
    {
      boolean bool = iwO().Wzl.sLC.blq("favorite");
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
  
  public final void ixX()
  {
    boolean bool = false;
    AppMethodBeat.i(79899);
    if ((iwO() == null) || (iwO().sLD == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "showShareMenu params failed");
      AppMethodBeat.o(79899);
      return;
    }
    final JsapiPermissionWrapper localJsapiPermissionWrapper = iwO().sLD.iwo();
    if ((!a(localJsapiPermissionWrapper, 21, 1)) && (!a(localJsapiPermissionWrapper, 23, 2)))
    {
      com.tencent.mm.ui.base.k.cZ(iwO(), iwO().getString(c.i.wv_block_shared_tips));
      AppMethodBeat.o(79899);
      return;
    }
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(iwO(), 1, false);
    localf.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(296463);
        if (o.this.a(localJsapiPermissionWrapper, 21, 1)) {
          paramAnonymouss.a(1, o.this.iwO().getString(c.i.readerapp_alert_retransmit), c.h.bottomsheet_icon_transmit, false);
        }
        if (o.this.a(localJsapiPermissionWrapper, 23, 2)) {
          paramAnonymouss.a(2, o.this.iwO().getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, false);
        }
        AppMethodBeat.o(296463);
      }
    };
    localf.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        paramAnonymousInt = 0;
        AppMethodBeat.i(296462);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(296462);
          return;
          paramAnonymousMenuItem = o.this.iwO().getIntent().getStringExtra("KPublisherId");
          String str1 = o.this.iwO().getIntent().getStringExtra("KAppId");
          String str2 = o.this.iwO().getIntent().getStringExtra("srcUsername");
          o.this.iwO().Wye.ivL().F(new Object[] { o.this.iwO().dgY(), Integer.valueOf(1), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          o.this.iwO().auy(1);
          AppMethodBeat.o(296462);
          return;
          paramAnonymousMenuItem = o.this.iwO().getIntent().getStringExtra("KPublisherId");
          str1 = o.this.iwO().getIntent().getStringExtra("KAppId");
          str2 = o.this.iwO().getIntent().getStringExtra("srcUsername");
          o.this.iwO().Wye.ivL().F(new Object[] { o.this.iwO().dgY(), Integer.valueOf(2), Integer.valueOf(1), paramAnonymousMenuItem, str1, str2 }).report();
          if (o.this.WVp.containsKey(o.this.iwO().sMP.getUrl())) {
            paramAnonymousInt = ((Integer)o.this.WVp.get(o.this.iwO().sMP.getUrl())).intValue();
          }
          o.a(o.this, paramAnonymousInt, 1);
        }
      }
    };
    localf.h(" ", 1, 0);
    if ((this.WVq) || (iwO().iyR() == 16)) {
      bool = true;
    }
    localf.sRz = bool;
    localf.dDn();
    AppMethodBeat.o(79899);
  }
  
  public final void ixY()
  {
    AppMethodBeat.i(79900);
    if ((iwO() == null) || (iwO().sMP == null) || (iwO().sLD == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "setShareFuncFlag params failed");
      AppMethodBeat.o(79900);
      return;
    }
    String str = iwO().sMP.getUrl();
    if (!Util.isNullOrNil(str))
    {
      try
      {
        boolean bool = new URL(str).getHost().equals(WeChatHosts.domainString(c.i.host_mp_weixin_qq_com));
        if (bool) {
          break label140;
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
    label140:
    int i = ixZ();
    if (iwO().WlX != null)
    {
      com.tencent.mm.plugin.webview.jsapi.j localj = iwO().WlX;
      if (localj.UcS)
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("action", "setFuncFlag");
        ((HashMap)localObject).put("shareFuncFlag", Integer.valueOf(i));
        localObject = p.a.b("onMPPageAction", (Map)localObject, localj.WDI, localj.KQY);
        localj.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
      }
    }
    AppMethodBeat.o(79900);
  }
  
  public final int ixZ()
  {
    AppMethodBeat.i(79901);
    if ((iwO() == null) || (iwO().sLD == null))
    {
      Log.e("MicroMsg.WebViewMenuHelper", "getShareFuncFlag params failed");
      AppMethodBeat.o(79901);
      return -1;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = iwO().sLD.iwo();
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
  
  final void mj(List<String> paramList)
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
        break label316;
      }
      String str2 = (String)localIterator.next();
      if (this.WVj.get(str2) != null) {
        Log.i("MicroMsg.WebViewMenuHelper", "find %s icon from cache ok", new Object[] { str2 });
      }
      for (;;)
      {
        if (!this.WVk.containsKey(str2)) {
          break label221;
        }
        Log.i("MicroMsg.WebViewMenuHelper", "find %s nick from cache ok", new Object[] { str2 });
        break;
        Log.w("MicroMsg.WebViewMenuHelper", "not found %s icon from cache, try to load", new Object[] { str2 });
        try
        {
          paramList = iwO().Wzl.sLC.blm(str2);
          if (!Util.isNullOrNil(paramList))
          {
            paramList = f.blB(paramList);
            if (paramList != null)
            {
              Log.i("MicroMsg.WebViewMenuHelper", "load ok, and cache it");
              this.WVj.put(str2, paramList);
            }
          }
        }
        catch (Exception paramList)
        {
          Log.w("MicroMsg.WebViewMenuHelper", "getheadimg, ex = " + paramList.getMessage());
        }
      }
      label221:
      Log.w("MicroMsg.WebViewMenuHelper", "not found %s nick from cache, try to load", new Object[] { str2 });
      paramList = null;
      try
      {
        String str1 = iwO().Wzl.sLC.getDisplayName(str2);
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
      this.WVk.put(str2, paramList);
    }
    label316:
    AppMethodBeat.o(79894);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(79878);
    Iterator localIterator = this.WVh.values().iterator();
    while (localIterator.hasNext())
    {
      SparseBooleanArray localSparseBooleanArray = (SparseBooleanArray)localIterator.next();
      if (localSparseBooleanArray != null) {
        localSparseBooleanArray.clear();
      }
    }
    this.WVh.clear();
    this.WVp.clear();
    ixN();
    this.WVA = null;
    AppMethodBeat.o(79878);
  }
  
  static final class a
    implements com.tencent.mm.plugin.appbrand.openmaterial.j
  {
    private final com.tencent.mm.plugin.appbrand.service.j WVQ;
    private final String url;
    private final WeakReference<o> vvs;
    
    public a(o paramo, String paramString, com.tencent.mm.plugin.appbrand.service.j paramj)
    {
      AppMethodBeat.i(296171);
      this.vvs = new WeakReference(paramo);
      this.url = paramString;
      this.WVQ = paramj;
      AppMethodBeat.o(296171);
    }
    
    public final void a(boolean paramBoolean, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(296176);
      o localo = (o)this.vvs.get();
      if (localo == null)
      {
        Log.i("MicroMsg.WebViewMenuHelper", "onOpenMaterialsGot, menuHelper is null");
        AppMethodBeat.o(296176);
        return;
      }
      if (!paramBoolean)
      {
        Log.i("MicroMsg.WebViewMenuHelper", "onOpenMaterialsGot, fail");
        AppMethodBeat.o(296176);
        return;
      }
      localo.WVy = this.url;
      localo.WVz = paramAppBrandOpenMaterialCollection;
      localo.a(this.WVQ);
      AppMethodBeat.o(296176);
    }
  }
  
  final class b
    implements com.tencent.mm.vending.e.a
  {
    private boolean WVR;
    
    public b()
    {
      AppMethodBeat.i(296165);
      this.WVR = false;
      Log.i("MicroMsg.WebViewMenuHelper", "<init>#OpenMaterialReleaser");
      AppMethodBeat.o(296165);
    }
    
    public final void a(WebViewUI paramWebViewUI)
    {
      AppMethodBeat.i(296168);
      Log.i("MicroMsg.WebViewMenuHelper", "keepMyself#OpenMaterialReleaser, isKept: " + this.WVR);
      if (!this.WVR)
      {
        paramWebViewUI.keep(this);
        this.WVR = true;
      }
      AppMethodBeat.o(296168);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(296169);
      Log.i("MicroMsg.WebViewMenuHelper", "dead#OpenMaterialReleaser, isKept: " + this.WVR);
      o.this.WVy = null;
      o.this.WVz = null;
      o.this.WVA = null;
      this.WVR = false;
      AppMethodBeat.o(296169);
    }
  }
  
  public static final class c
  {
    public int WVS = -1;
    public Bundle WVT = null;
    public boolean disable = false;
    public int tlb = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */