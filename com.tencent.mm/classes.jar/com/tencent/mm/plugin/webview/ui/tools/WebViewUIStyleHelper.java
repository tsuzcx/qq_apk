package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.webview.WebViewTransHelper;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.k.t;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class WebViewUIStyleHelper
{
  static Map<String, Bundle> GYh;
  IListener Ixi;
  private com.tencent.mm.plugin.brandservice.api.a Ixk;
  public WebViewUI WUm;
  int WXq;
  public boolean WZj;
  public boolean WZk;
  public l WZl;
  public WebViewTransHelper WZm;
  private View WZn;
  private View WZo;
  private View WZp;
  private View WZq;
  private View WZr;
  private View WZs;
  private TextView WZt;
  public View WZu;
  public boolean WZv;
  private long WZw;
  private final long WZx;
  private MMHandler handler;
  public String sML;
  public MMWebView webView;
  
  static
  {
    AppMethodBeat.i(175837);
    GYh = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public WebViewUIStyleHelper(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.WZj = false;
    this.WZk = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Ixi = null;
    this.Ixk = null;
    this.WZn = null;
    this.WZo = null;
    this.WZp = null;
    this.WZq = null;
    this.WZr = null;
    this.WZs = null;
    this.WZt = null;
    this.WZu = null;
    this.WZv = false;
    this.WZw = SystemClock.elapsedRealtime();
    this.WZx = 175L;
    this.WXq = -1;
    this.WUm = paramWebViewUI;
    this.WZl = new l(paramWebViewUI);
    onCreate();
    AppMethodBeat.o(175830);
  }
  
  private static void a(View paramView, y paramy)
  {
    AppMethodBeat.i(296204);
    paramy = paramy.mActionBar.getCustomView();
    if ((paramy instanceof LinearLayout))
    {
      ((LinearLayout)paramy).addView(paramView);
      paramy = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramy.width = -1;
      paramy.height = -1;
      paramy.weight = 1.0F;
      paramView.setLayoutParams(paramy);
      AppMethodBeat.o(296204);
      return;
    }
    if ((paramy instanceof RelativeLayout))
    {
      ((RelativeLayout)paramy).addView(paramView);
      paramy = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramy.width = -1;
      paramy.height = -1;
      paramView.setLayoutParams(paramy);
    }
    AppMethodBeat.o(296204);
  }
  
  static String aiC(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (com.tencent.mm.kernel.h.ax(c.class) == null) || (!((c)com.tencent.mm.kernel.h.ax(c.class)).aiy(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((c)com.tencent.mm.kernel.h.ax(c.class)).aiC(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  private void auz(int paramInt)
  {
    AppMethodBeat.i(296208);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
    com.tencent.mm.plugin.bizui.a.a.r(this.WZs, paramInt, paramInt * 2);
    AppMethodBeat.o(296208);
  }
  
  static boolean bE(Bundle paramBundle)
  {
    AppMethodBeat.i(296226);
    if (paramBundle == null)
    {
      AppMethodBeat.o(296226);
      return false;
    }
    if (!bF(paramBundle))
    {
      AppMethodBeat.o(296226);
      return false;
    }
    String str = paramBundle.getString("key_url");
    if ((Util.isNullOrNil(str)) || (com.tencent.mm.kernel.h.ax(c.class) == null) || (!((c)com.tencent.mm.kernel.h.ax(c.class)).aiy(str)))
    {
      AppMethodBeat.o(296226);
      return false;
    }
    if (!fEm())
    {
      AppMethodBeat.o(296226);
      return false;
    }
    paramBundle = paramBundle.getString("key_brand_user_name");
    boolean bool = ((c)com.tencent.mm.kernel.h.ax(c.class)).aiF(paramBundle);
    AppMethodBeat.o(296226);
    return bool;
  }
  
  static boolean bF(Bundle paramBundle)
  {
    AppMethodBeat.i(296230);
    if (paramBundle == null)
    {
      AppMethodBeat.o(296230);
      return false;
    }
    boolean bool = paramBundle.getBoolean("key_show_live_top_bar", true);
    AppMethodBeat.o(296230);
    return bool;
  }
  
  private String blU(String paramString)
  {
    AppMethodBeat.i(296216);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = Uri.parse(paramString);
        int i = Util.getInt(paramString.getQueryParameter("idx"), 0);
        long l = Util.getLong(paramString.getQueryParameter("mid"), 0L);
        this.WXq = Util.getInt(paramString.getQueryParameter("scene"), 0);
        paramString = l + "#" + i;
        AppMethodBeat.o(296216);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(296216);
    return "";
  }
  
  public static a blV(String paramString)
  {
    AppMethodBeat.i(175835);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = aiC(paramString);
    Object localObject = (Bundle)GYh.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(175835);
      return null;
    }
    String str2 = ((Bundle)localObject).getString("key_brand_name");
    String str3 = ((Bundle)localObject).getString("key_brand_user_name");
    paramString = ((Bundle)localObject).getString("key_bag_icon");
    String str4 = ((Bundle)localObject).getString("key_title");
    String str1 = ((Bundle)localObject).getString("key_cover");
    boolean bool1 = ((Bundle)localObject).getBoolean("key_show_menu_onfo", false);
    int i = ((Bundle)localObject).getInt("key_item_show_type", -1);
    boolean bool2 = ((Bundle)localObject).getBoolean("key_disable_menu_header", false);
    localObject = ((Bundle)localObject).getString("key_mp_vid", "");
    a locala = new a();
    locala.WZF = paramString;
    locala.WZE = str2;
    locala.owR = str3;
    locala.WOH = bool1;
    locala.title = str4;
    if (Util.isNullOrNil(str1)) {}
    for (;;)
    {
      locala.nUM = paramString;
      locala.nQm = i;
      locala.WOJ = bool2;
      locala.vid = ((String)localObject);
      AppMethodBeat.o(175835);
      return locala;
      paramString = str1;
    }
  }
  
  public static boolean fEm()
  {
    AppMethodBeat.i(296195);
    if ((com.tencent.mm.kernel.h.ax(c.class) != null) && (((c)com.tencent.mm.kernel.h.ax(c.class)).dbD()))
    {
      AppMethodBeat.o(296195);
      return true;
    }
    AppMethodBeat.o(296195);
    return false;
  }
  
  private boolean izo()
  {
    AppMethodBeat.i(80401);
    if (this.WUm == null)
    {
      AppMethodBeat.o(80401);
      return true;
    }
    if (this.WUm.cKZ())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    if (this.WZk)
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.WUm.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getBooleanExtra("disable_light_actionbar_style", false))
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
        AppMethodBeat.o(80401);
        return true;
      }
      String str = localIntent.getStringExtra("status_bar_style");
      if ((!Util.isNullOrNil(str)) && (str.equals("black")))
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getIntExtra("customize_status_bar_color", 0) != 0)
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("open_custom_style_url", false))
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("show_full_screen", false))
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
        AppMethodBeat.o(80401);
        return true;
      }
    }
    AppMethodBeat.o(80401);
    return false;
  }
  
  private void izq()
  {
    AppMethodBeat.i(80403);
    if (this.WUm == null)
    {
      AppMethodBeat.o(80403);
      return;
    }
    View localView = this.WUm.findViewById(c.f.webview_logo_container);
    if ((localView != null) && (!this.WUm.WYp.ixy()) && (!this.WZl.WUn)) {
      localView.setBackgroundColor(izv());
    }
    int i = this.WUm.getResources().getColor(c.c.webview_x5logo_text_color);
    localView = this.WUm.findViewById(c.f.x5_logo_url);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.WUm.findViewById(c.f.info_txt);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.WUm.findViewById(c.f.x5_logo_img);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(c.h.webview_logo_qqbrowser_light);
    }
    AppMethodBeat.o(80403);
  }
  
  private void izr()
  {
    AppMethodBeat.i(80404);
    if (this.WUm == null)
    {
      AppMethodBeat.o(80404);
      return;
    }
    if ((this.WUm.WYp.ixy()) || (this.WUm.WYp.WUq))
    {
      AppMethodBeat.o(80404);
      return;
    }
    int i = izv();
    this.WUm.setActionbarColor(i);
    AppMethodBeat.o(80404);
  }
  
  private void izx()
  {
    AppMethodBeat.i(296198);
    if (this.WUm == null)
    {
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.sML });
      AppMethodBeat.o(296198);
      return;
    }
    if (this.WZu == null)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "init transHelpEntryLayout");
      this.WZu = this.WUm.getLayoutInflater().inflate(c.g.webview_top_bar_trans_help_entry, null);
      a(this.WZu, this.WUm.getController());
      ((Button)this.WZu.findViewById(c.f.transBtn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(296305);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.WebViewUIStyleHelper", "click trans help button");
          if (WebViewUI.iyl()) {
            WebViewUIStyleHelper.this.WZm.a(g.WuE);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(296305);
            return;
            WebViewUIStyleHelper.this.WUm.d(new Callable() {});
          }
        }
      });
    }
    AppMethodBeat.o(296198);
  }
  
  public final void a(com.tencent.mm.plugin.webview.h paramh, com.tencent.mm.plugin.webview.i parami)
  {
    AppMethodBeat.i(296360);
    if (this.WUm == null)
    {
      AppMethodBeat.o(296360);
      return;
    }
    com.tencent.mm.plugin.webview.h localh = paramh;
    com.tencent.mm.plugin.webview.i locali = parami;
    if (paramh == com.tencent.mm.plugin.webview.h.WuI)
    {
      localh = paramh;
      locali = parami;
      if (parami == com.tencent.mm.plugin.webview.i.WuL)
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "change trans help button Status and Action");
        locali = com.tencent.mm.plugin.webview.i.WuM;
        localh = com.tencent.mm.plugin.webview.h.WuH;
      }
    }
    Log.i("MicroMsg.WebViewUIStyleHelper", "trans help button Action: %s, Status: %s", new Object[] { localh.name(), locali.name() });
    izx();
    paramh = (TextView)this.WZu.findViewById(c.f.showText);
    parami = (WeImageView)this.WZu.findViewById(c.f.showIcon);
    if (locali == com.tencent.mm.plugin.webview.i.WuL)
    {
      paramh.setText(c.i.webview_menu_tranlate);
      parami.setImageResource(c.h.icons_outlined_translate);
    }
    while (localh == com.tencent.mm.plugin.webview.h.WuG)
    {
      AppMethodBeat.o(296360);
      return;
      if (locali == com.tencent.mm.plugin.webview.i.WuM)
      {
        paramh.setText(c.i.webview_menu_tranlate_revert);
        parami.setImageResource(c.h.icons_outlined_stoptranslate);
      }
    }
    if (localh == com.tencent.mm.plugin.webview.h.WuI)
    {
      this.WZv = true;
      if (izu()) {
        izz();
      }
      this.WUm.getController().setMMTitleVisibility(8);
      this.WZu.setVisibility(0);
      AppMethodBeat.o(296360);
      return;
    }
    if (localh == com.tencent.mm.plugin.webview.h.WuH)
    {
      this.WZv = false;
      this.WZu.setVisibility(8);
      this.WUm.getController().setMMTitleVisibility(0);
      if (izu()) {
        izw();
      }
    }
    AppMethodBeat.o(296360);
  }
  
  final void aiO(String paramString)
  {
    AppMethodBeat.i(296308);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "startCheck fail bizUserName is null");
      AppMethodBeat.o(296308);
      return;
    }
    if (this.Ixk == null) {
      this.Ixk = ((c)com.tencent.mm.kernel.h.ax(c.class)).GX(9);
    }
    this.Ixk.aiO(paramString);
    AppMethodBeat.o(296308);
  }
  
  public final void bD(final Bundle paramBundle)
  {
    AppMethodBeat.i(175831);
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175825);
        if ((WebViewUIStyleHelper.this.WUm == null) || (WebViewUIStyleHelper.this.WUm.isFinishing()))
        {
          AppMethodBeat.o(175825);
          return;
        }
        boolean bool = paramBundle.getBoolean("key_current_info_show");
        Bundle localBundle = (Bundle)WebViewUIStyleHelper.aCw().get(WebViewUIStyleHelper.blW(WebViewUIStyleHelper.this.sML));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if ((bool) || (WebViewUIStyleHelper.bG(localBundle)))
        {
          WebViewUIStyleHelper.this.izy();
          AppMethodBeat.o(175825);
          return;
        }
        WebViewUIStyleHelper.this.izz();
        AppMethodBeat.o(175825);
      }
    };
    com.tencent.threadpool.h.ahAA.bk(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  public final void izn()
  {
    AppMethodBeat.i(296296);
    if (this.WUm == null)
    {
      AppMethodBeat.o(296296);
      return;
    }
    if (izo()) {}
    for (this.WZj = true;; this.WZj = false)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "initNewWebViewUIStyleParams, webViewUI#%s, disableLightActionbarStyle:%b", new Object[] { this.WUm, Boolean.valueOf(this.WZj) });
      AppMethodBeat.o(296296);
      return;
    }
  }
  
  final void izp()
  {
    AppMethodBeat.i(80402);
    izr();
    izq();
    izt();
    AppMethodBeat.o(80402);
  }
  
  final void izs()
  {
    AppMethodBeat.i(296317);
    if (this.Ixk != null) {
      this.Ixk.stopCheck();
    }
    AppMethodBeat.o(296317);
  }
  
  public final void izt()
  {
    AppMethodBeat.i(80405);
    if (this.WUm == null)
    {
      AppMethodBeat.o(80405);
      return;
    }
    if (!izu())
    {
      this.WUm.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    if ((this.webView != null) && (this.webView.getWebScrollY() > 0))
    {
      this.WUm.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    this.WUm.hideActionbarLine();
    AppMethodBeat.o(80405);
  }
  
  public final boolean izu()
  {
    AppMethodBeat.i(80406);
    if (this.WUm == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.sML;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = this.WUm.dgY();
    }
    boolean bool = t.bnd(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final int izv()
  {
    AppMethodBeat.i(80407);
    if (this.WUm == null)
    {
      AppMethodBeat.o(80407);
      return 0;
    }
    if (izu())
    {
      i = this.WUm.getResources().getColor(c.c.webview_mp_actionbar_color);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.WUm.getResources().getColor(c.c.webview_actionbar_color);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void izw()
  {
    AppMethodBeat.i(296350);
    Bundle localBundle = (Bundle)GYh.get(aiC(this.sML));
    if ((localBundle == null) || (this.WUm == null))
    {
      izz();
      AppMethodBeat.o(296350);
      return;
    }
    if ((localBundle.getBoolean("key_current_info_show")) || (bE(localBundle)))
    {
      izy();
      AppMethodBeat.o(296350);
      return;
    }
    izz();
    AppMethodBeat.o(296350);
  }
  
  public final void izy()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)GYh.get(aiC(this.sML));
    if ((localObject1 == null) || (this.WUm == null))
    {
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.sML });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.WUm.WWP)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    if (this.WZv)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "trans help button shown, do not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    if (this.WZu != null) {
      this.WZu.setVisibility(8);
    }
    this.WUm.getController().setMMTitleVisibility(8);
    if (this.WZn == null)
    {
      this.WZn = this.WUm.getLayoutInflater().inflate(c.g.webview_top_bar_layout, null);
      this.WZo = this.WZn.findViewById(c.f.webview_top_bar_click_view);
      this.WZq = this.WZn.findViewById(c.f.webview_top_bar_bg_view);
      this.WZr = this.WZn.findViewById(c.f.webview_top_bar_padding_view);
      this.WZt = ((TextView)this.WZn.findViewById(c.f.nickname_tv));
      this.WZs = this.WZn.findViewById(c.f.right_arrow_iv);
      this.WZp = this.WZn.findViewById(c.f.live_tipsbar_title_icon);
      a(this.WZn, this.WUm.getController());
    }
    String str3 = ((Bundle)localObject1).getString("key_brand_name");
    final String str2 = ((Bundle)localObject1).getString("key_brand_user_name");
    final String str1;
    if (com.tencent.mm.kernel.h.ax(c.class) != null)
    {
      str1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).aiD(str2);
      if ((Util.isNullOrNil(str1)) || (!bE((Bundle)localObject1))) {
        break label435;
      }
    }
    final boolean bool2;
    label435:
    for (final boolean bool1 = true;; bool1 = false)
    {
      bool2 = ((Bundle)localObject1).getBoolean("key_current_info_show");
      Log.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s, isLiveNow:%b, show %b", new Object[] { str2, str3, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!Util.isNullOrNil(str3)) && (!Util.isNullOrNil(str2))) {
        break label441;
      }
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", new Object[] { str2, str3 });
      AppMethodBeat.o(175832);
      return;
      str1 = "";
      break;
    }
    label441:
    this.WUm.setMMTitle("");
    this.WZn.setVisibility(0);
    Object localObject2 = this.WZp;
    label492:
    final int j;
    label602:
    int k;
    int m;
    if (bool1)
    {
      i = 0;
      ((View)localObject2).setVisibility(i);
      localObject2 = this.WZr;
      if (!bool1) {
        break label773;
      }
      i = 8;
      ((View)localObject2).setVisibility(i);
      i = com.tencent.mm.cd.a.fromDPToPix(this.WUm, 4);
      j = this.WUm.getIntent().getIntExtra(f.s.adwS, 0);
      if ((!bool1) || (bool2)) {
        break label778;
      }
      this.WZt.setText(this.WUm.getString(c.i.biz_time_line_finder_live_title));
      this.WZq.setBackgroundResource(c.e.webview_top_bar_live_bg);
      this.WZt.setTextSize(1, 13.0F);
      aw.e(this.WZt.getPaint());
      this.WZq.setPadding(i * 3, 0, i * 3, 0);
      auz(i * 2);
      localObject1 = ((Bundle)localObject1).getString("key_url");
      if (bool1)
      {
        k = ((c)com.tencent.mm.kernel.h.ax(c.class)).aiE(str2);
        str3 = blU((String)localObject1);
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        m = this.WXq;
        if (!bool2) {
          break label866;
        }
      }
    }
    label773:
    label778:
    label866:
    for (int i = 3;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).b(23044, new Object[] { Integer.valueOf(1), str2, Integer.valueOf(m), Integer.valueOf(j), str1, Integer.valueOf(k), Integer.valueOf(i), str3 });
      this.WZo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175828);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((WebViewUIStyleHelper.this.WUm == null) || (WebViewUIStyleHelper.this.WUm.WYi == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175828);
            return;
          }
          if (SystemClock.elapsedRealtime() - WebViewUIStyleHelper.a(WebViewUIStyleHelper.this) < 175L)
          {
            WebViewUIStyleHelper.b(WebViewUIStyleHelper.this).removeCallbacksAndMessages(null);
            WebViewUIStyleHelper.this.WUm.iyN();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175828);
            return;
          }
          WebViewUIStyleHelper.a(WebViewUIStyleHelper.this, SystemClock.elapsedRealtime());
          WebViewUIStyleHelper.b(WebViewUIStyleHelper.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175827);
              int j;
              Object localObject;
              String str1;
              int k;
              int m;
              String str2;
              if (WebViewUIStyleHelper.3.this.WZA)
              {
                j = ((c)com.tencent.mm.kernel.h.ax(c.class)).aiE(WebViewUIStyleHelper.3.this.lzH);
                localObject = com.tencent.mm.plugin.report.service.h.OAn;
                str1 = WebViewUIStyleHelper.3.this.lzH;
                k = WebViewUIStyleHelper.this.WXq;
                m = WebViewUIStyleHelper.3.this.WZB;
                str2 = WebViewUIStyleHelper.3.this.Iws;
                if (!WebViewUIStyleHelper.3.this.val$show) {
                  break label246;
                }
              }
              label246:
              for (int i = 3;; i = 2)
              {
                ((com.tencent.mm.plugin.report.service.h)localObject).b(23044, new Object[] { Integer.valueOf(2), str1, Integer.valueOf(k), Integer.valueOf(m), str2, Integer.valueOf(j), Integer.valueOf(i), WebViewUIStyleHelper.a(WebViewUIStyleHelper.this, WebViewUIStyleHelper.3.this.val$url) });
                if ((!WebViewUIStyleHelper.3.this.WZA) || (WebViewUIStyleHelper.3.this.val$show)) {
                  break;
                }
                localObject = new Bundle();
                ((Bundle)localObject).putString("userName", WebViewUIStyleHelper.3.this.lzH);
                ((Bundle)localObject).putString("exportId", WebViewUIStyleHelper.3.this.Iws);
                XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, WebViewUIStyleHelper.b.class, null);
                AppMethodBeat.o(175827);
                return;
              }
              WebViewUIStyleHelper.this.WUm.WYi.ie("Contact_Scene", 154);
              WebViewUIStyleHelper.this.WUm.blQ(WebViewUIStyleHelper.3.this.lzH);
              if (WebViewUIStyleHelper.this.WUm.WlX != null)
              {
                localObject = WebViewUIStyleHelper.this.WUm.WlX;
                if (((j)localObject).UcS)
                {
                  str1 = p.a.b("topbar:click", null, ((j)localObject).WDI, ((j)localObject).KQY);
                  ((j)localObject).WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str1 + ")", null);
                }
              }
              WebViewUIStyleHelper.b(WebViewUIStyleHelper.this).removeCallbacksAndMessages(null);
              AppMethodBeat.o(175827);
            }
          }, 175L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
        }
      });
      com.tencent.mm.ui.tools.o.F(this.WZo, 0.7F);
      AppMethodBeat.o(175832);
      return;
      i = 8;
      break;
      i = 4;
      break label492;
      this.WZt.setText(p.b(this.WUm, str3, this.WZt.getTextSize()));
      this.WZq.setBackgroundResource(c.c.transparent);
      this.WZt.setTextSize(1, 17.0F);
      aw.a(this.WZt.getPaint(), 0.8F);
      this.WZq.setPadding(i * 2, 0, i * 2, 0);
      auz(com.tencent.mm.cd.a.fromDPToPix(this.WUm, 10));
      break label602;
    }
  }
  
  public final void izz()
  {
    AppMethodBeat.i(175833);
    if (this.WUm == null)
    {
      AppMethodBeat.o(175833);
      return;
    }
    this.WUm.getController().setMMTitleVisibility(0);
    if (this.WZn != null) {
      this.WZn.setVisibility(8);
    }
    izs();
    AppMethodBeat.o(175833);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(296304);
    if ((this.Ixi == null) && (fEm()))
    {
      this.Ixi = new BizFinderLineStatusChangedEventListenerImpl(this);
      this.Ixi.alive();
    }
    AppMethodBeat.o(296304);
  }
  
  static class BizFinderLineStatusChangedEventListenerImpl
    extends IListener<at>
  {
    private WeakReference<WebViewUIStyleHelper> Ixt;
    
    public BizFinderLineStatusChangedEventListenerImpl(WebViewUIStyleHelper paramWebViewUIStyleHelper)
    {
      super();
      AppMethodBeat.i(296254);
      this.Ixt = new WeakReference(paramWebViewUIStyleHelper);
      this.__eventId = at.class.getName().hashCode();
      AppMethodBeat.o(296254);
    }
  }
  
  public static final class a
  {
    public boolean WOH;
    public boolean WOJ;
    public String WZE;
    public String WZF;
    public int nQm;
    public String nUM;
    public String owR;
    public String title;
    public String vid;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!Util.isNullOrNil(this.WZF)) && (!Util.isNullOrNil(this.WZE)) && (!Util.isNullOrNil(this.owR)) && (this.WOH))
      {
        AppMethodBeat.o(175829);
        return true;
      }
      AppMethodBeat.o(175829);
      return false;
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static final class b
    implements d<Bundle, Object>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper
 * JD-Core Version:    0.7.0.1
 */