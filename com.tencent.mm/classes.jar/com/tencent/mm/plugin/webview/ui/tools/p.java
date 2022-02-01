package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ap;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.webview.WebViewTransHelper;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.o;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class p
{
  static Map<String, Bundle> BrL;
  private com.tencent.mm.plugin.brandservice.a.a Hgq;
  IListener Hgr;
  public WebViewUI QcD;
  int Qfr;
  boolean Qhl;
  public WebViewTransHelper Qhm;
  private View Qhn;
  private View Qho;
  private View Qhp;
  private View Qhq;
  private View Qhr;
  private View Qhs;
  private TextView Qht;
  public View Qhu;
  public boolean Qhv;
  private long Qhw;
  private final long Qhx;
  private MMHandler handler;
  public String pHO;
  public MMWebView webView;
  
  static
  {
    AppMethodBeat.i(175837);
    BrL = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public p(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.Qhl = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Hgr = null;
    this.Hgq = null;
    this.Qhn = null;
    this.Qho = null;
    this.Qhp = null;
    this.Qhq = null;
    this.Qhr = null;
    this.Qhs = null;
    this.Qht = null;
    this.Qhu = null;
    this.Qhv = false;
    this.Qhw = SystemClock.elapsedRealtime();
    this.Qhx = 175L;
    this.Qfr = -1;
    this.QcD = paramWebViewUI;
    onCreate();
    AppMethodBeat.o(175830);
  }
  
  private void aoG(int paramInt)
  {
    AppMethodBeat.i(215757);
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.shG;
    com.tencent.mm.plugin.bizui.a.a.r(this.Qhs, paramInt, paramInt * 2);
    AppMethodBeat.o(215757);
  }
  
  static String apf(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (com.tencent.mm.kernel.h.ae(c.class) == null) || (!((c)com.tencent.mm.kernel.h.ae(c.class)).apb(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((c)com.tencent.mm.kernel.h.ae(c.class)).apf(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  static boolean bb(Bundle paramBundle)
  {
    AppMethodBeat.i(215760);
    if (paramBundle == null)
    {
      AppMethodBeat.o(215760);
      return false;
    }
    if (!bz(paramBundle))
    {
      AppMethodBeat.o(215760);
      return false;
    }
    String str = paramBundle.getString("key_url");
    if ((Util.isNullOrNil(str)) || (!((c)com.tencent.mm.kernel.h.ae(c.class)).apb(str)))
    {
      AppMethodBeat.o(215760);
      return false;
    }
    if (!gZs())
    {
      AppMethodBeat.o(215760);
      return false;
    }
    paramBundle = paramBundle.getString("key_brand_user_name");
    boolean bool = ((c)com.tencent.mm.kernel.h.ae(c.class)).api(paramBundle);
    AppMethodBeat.o(215760);
    return bool;
  }
  
  private String bms(String paramString)
  {
    AppMethodBeat.i(215758);
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = Uri.parse(paramString);
        int i = Util.getInt(paramString.getQueryParameter("idx"), 0);
        long l = Util.getLong(paramString.getQueryParameter("mid"), 0L);
        this.Qfr = Util.getInt(paramString.getQueryParameter("scene"), 0);
        paramString = l + "#" + i;
        AppMethodBeat.o(215758);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(215758);
    return "";
  }
  
  public static b bmu(String paramString)
  {
    AppMethodBeat.i(175835);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = apf(paramString);
    Object localObject = (Bundle)BrL.get(paramString);
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
    boolean bool = ((Bundle)localObject).getBoolean("key_show_menu_onfo", false);
    localObject = new b();
    ((b)localObject).QhG = paramString;
    ((b)localObject).QhF = str2;
    ((b)localObject).lFl = str3;
    ((b)localObject).PYi = bool;
    ((b)localObject).title = str4;
    if (Util.isNullOrNil(str1)) {}
    for (;;)
    {
      ((b)localObject).lpK = paramString;
      AppMethodBeat.o(175835);
      return localObject;
      paramString = str1;
    }
  }
  
  static boolean bz(Bundle paramBundle)
  {
    AppMethodBeat.i(292961);
    if (paramBundle == null)
    {
      AppMethodBeat.o(292961);
      return false;
    }
    boolean bool = paramBundle.getBoolean("key_show_live_top_bar", true);
    AppMethodBeat.o(292961);
    return bool;
  }
  
  @SuppressLint({"ResourceType"})
  private void gZq()
  {
    AppMethodBeat.i(80403);
    View localView = this.QcD.findViewById(c.f.webview_logo_container);
    if (localView != null) {
      localView.setBackgroundColor(gZw());
    }
    int i = this.QcD.getResources().getColor(c.c.webview_x5logo_text_color);
    localView = this.QcD.findViewById(c.f.x5_logo_url);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.QcD.findViewById(c.f.info_txt);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.QcD.findViewById(c.f.x5_logo_img);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(c.h.webview_logo_qqbrowser_light);
    }
    AppMethodBeat.o(80403);
  }
  
  private void gZr()
  {
    AppMethodBeat.i(80404);
    if (this.QcD.Qgr.QcC.PQp)
    {
      AppMethodBeat.o(80404);
      return;
    }
    int i = gZw();
    this.QcD.setActionbarColor(i);
    AppMethodBeat.o(80404);
  }
  
  public static boolean gZs()
  {
    AppMethodBeat.i(215743);
    boolean bool = ((c)com.tencent.mm.kernel.h.ae(c.class)).cyG();
    AppMethodBeat.o(215743);
    return bool;
  }
  
  private void ho(View paramView)
  {
    AppMethodBeat.i(215755);
    Object localObject = this.QcD.getController().mActionBar.getCustomView();
    if ((localObject instanceof LinearLayout))
    {
      ((LinearLayout)localObject).addView(paramView);
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = -1;
      ((LinearLayout.LayoutParams)localObject).height = -1;
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(215755);
      return;
    }
    if ((localObject instanceof RelativeLayout))
    {
      ((RelativeLayout)localObject).addView(paramView);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      ((RelativeLayout.LayoutParams)localObject).height = -1;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(215755);
  }
  
  public final void a(com.tencent.mm.plugin.webview.h paramh, com.tencent.mm.plugin.webview.i parami)
  {
    AppMethodBeat.i(215754);
    com.tencent.mm.plugin.webview.h localh = paramh;
    com.tencent.mm.plugin.webview.i locali = parami;
    if (paramh == com.tencent.mm.plugin.webview.h.PEf)
    {
      localh = paramh;
      locali = parami;
      if (parami == com.tencent.mm.plugin.webview.i.PEi)
      {
        Log.i("MicroMsg.WebViewUIStyleHelper", "change trans help button Status and Action");
        locali = com.tencent.mm.plugin.webview.i.PEj;
        localh = com.tencent.mm.plugin.webview.h.PEe;
      }
    }
    Log.i("MicroMsg.WebViewUIStyleHelper", "trans help button Action: %s, Status: %s", new Object[] { localh.name(), locali.name() });
    if (this.QcD == null)
    {
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.pHO });
      paramh = (TextView)this.Qhu.findViewById(c.f.showText);
      parami = (WeImageView)this.Qhu.findViewById(c.f.showIcon);
      if (locali != com.tencent.mm.plugin.webview.i.PEi) {
        break label236;
      }
      paramh.setText(c.i.webview_menu_tranlate);
      parami.setImageResource(c.h.icons_outlined_translate);
    }
    for (;;)
    {
      if (localh != com.tencent.mm.plugin.webview.h.PEd) {
        break label260;
      }
      AppMethodBeat.o(215754);
      return;
      if (this.Qhu != null) {
        break;
      }
      Log.i("MicroMsg.WebViewUIStyleHelper", "init transHelpEntryLayout");
      this.Qhu = this.QcD.getLayoutInflater().inflate(c.g.webview_top_bar_trans_help_entry, null);
      ho(this.Qhu);
      ((Button)this.Qhu.findViewById(c.f.transBtn)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214408);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.WebViewUIStyleHelper", "click trans help button");
          if (WebViewUI.gYq()) {
            p.this.Qhm.a(com.tencent.mm.plugin.webview.g.PEb);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(214408);
            return;
            p.this.QcD.d(new Callable() {});
          }
        }
      });
      break;
      label236:
      if (locali == com.tencent.mm.plugin.webview.i.PEj)
      {
        paramh.setText(c.i.webview_menu_tranlate_revert);
        parami.setImageResource(c.h.icons_outlined_stoptranslate);
      }
    }
    label260:
    if (localh == com.tencent.mm.plugin.webview.h.PEf)
    {
      this.Qhv = true;
      if (gZv()) {
        gZz();
      }
      this.QcD.getController().setMMTitleVisibility(8);
      this.Qhu.setVisibility(0);
      AppMethodBeat.o(215754);
      return;
    }
    if (localh == com.tencent.mm.plugin.webview.h.PEe)
    {
      this.Qhv = false;
      this.Qhu.setVisibility(8);
      this.QcD.getController().setMMTitleVisibility(0);
      if (gZv()) {
        gZx();
      }
    }
    AppMethodBeat.o(215754);
  }
  
  public final void a(o paramo, String paramString)
  {
    AppMethodBeat.i(215756);
    Log.i("MicroMsg.WebViewUIStyleHelper", "trans tips status is %s", new Object[] { paramo.name() });
    View localView = this.QcD.findViewById(c.f.trans_tips);
    localView.setBackgroundColor(gZw());
    TextView localTextView = (TextView)localView.findViewById(c.f.trans_tips_text);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(c.f.trans_tips_loading);
    switch (4.QhE[paramo.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215756);
      return;
      localView.setVisibility(8);
      AppMethodBeat.o(215756);
      return;
      localView.setVisibility(0);
      localTextView.setText(c.i.webview_menu_tranlate_waiting_tips);
      localProgressBar.setVisibility(0);
      AppMethodBeat.o(215756);
      return;
      localView.setVisibility(0);
      paramo = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramo = this.QcD.getResources().getString(c.i.webview_menu_tranlate_tips_brand);
      }
      localTextView.setText(paramo + this.QcD.getResources().getString(c.i.webview_menu_tranlate_tips));
      localProgressBar.setVisibility(4);
      AppMethodBeat.o(215756);
      return;
      localView.setVisibility(0);
      localTextView.setText(this.QcD.getResources().getString(c.i.webview_menu_tranlate_tips_no_trans));
      localProgressBar.setVisibility(4);
    }
  }
  
  final void apt(String paramString)
  {
    AppMethodBeat.i(215746);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "startCheck fail bizUserName is null");
      AppMethodBeat.o(215746);
      return;
    }
    if (this.Hgq == null) {
      this.Hgq = ((c)com.tencent.mm.kernel.h.ae(c.class)).Gy(9);
    }
    this.Hgq.apt(paramString);
    AppMethodBeat.o(215746);
  }
  
  public final void ba(final Bundle paramBundle)
  {
    AppMethodBeat.i(175831);
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175825);
        if ((p.this.QcD == null) || (p.this.QcD.isFinishing()))
        {
          AppMethodBeat.o(175825);
          return;
        }
        boolean bool = paramBundle.getBoolean("key_current_info_show");
        Bundle localBundle = (Bundle)p.avo().get(p.bmv(p.this.pHO));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if ((bool) || (p.bA(localBundle)))
        {
          p.this.gZy();
          AppMethodBeat.o(175825);
          return;
        }
        p.this.gZz();
        AppMethodBeat.o(175825);
      }
    };
    com.tencent.e.h.ZvG.bc(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  final boolean gZo()
  {
    AppMethodBeat.i(80401);
    if (this.QcD.cjM())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.QcD.getIntent();
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
  
  final void gZp()
  {
    AppMethodBeat.i(80402);
    gZr();
    gZq();
    gZu();
    AppMethodBeat.o(80402);
  }
  
  final void gZt()
  {
    AppMethodBeat.i(215747);
    if (this.Hgq != null) {
      this.Hgq.stopCheck();
    }
    AppMethodBeat.o(215747);
  }
  
  public final void gZu()
  {
    AppMethodBeat.i(80405);
    if (!gZv())
    {
      this.QcD.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    if ((this.webView != null) && (this.webView.getWebScrollY() > 0))
    {
      this.QcD.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    this.QcD.hideActionbarLine();
    AppMethodBeat.o(80405);
  }
  
  public final boolean gZv()
  {
    AppMethodBeat.i(80406);
    if (this.QcD == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.pHO;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = this.QcD.cDu();
    }
    boolean bool = com.tencent.mm.plugin.webview.k.p.bnq(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final int gZw()
  {
    AppMethodBeat.i(80407);
    if (gZv())
    {
      i = this.QcD.getResources().getColor(c.c.webview_mp_actionbar_color);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.QcD.getResources().getColor(c.c.webview_actionbar_color);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void gZx()
  {
    AppMethodBeat.i(215749);
    Bundle localBundle = (Bundle)BrL.get(apf(this.pHO));
    if ((localBundle == null) || (this.QcD == null))
    {
      gZz();
      AppMethodBeat.o(215749);
      return;
    }
    if ((localBundle.getBoolean("key_current_info_show")) || (bb(localBundle)))
    {
      gZy();
      AppMethodBeat.o(215749);
      return;
    }
    gZz();
    AppMethodBeat.o(215749);
  }
  
  public final void gZy()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)BrL.get(apf(this.pHO));
    if ((localObject1 == null) || (this.QcD == null))
    {
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.pHO });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.QcD.QeR)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    if (this.Qhv)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "trans help button shown, do not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    if (this.Qhu != null) {
      this.Qhu.setVisibility(8);
    }
    this.QcD.getController().setMMTitleVisibility(8);
    if (this.Qhn == null)
    {
      this.Qhn = this.QcD.getLayoutInflater().inflate(c.g.webview_top_bar_layout, null);
      this.Qho = this.Qhn.findViewById(c.f.webview_top_bar_click_view);
      this.Qhq = this.Qhn.findViewById(c.f.webview_top_bar_bg_view);
      this.Qhr = this.Qhn.findViewById(c.f.webview_top_bar_padding_view);
      this.Qht = ((TextView)this.Qhn.findViewById(c.f.nickname_tv));
      this.Qhs = this.Qhn.findViewById(c.f.right_arrow_iv);
      this.Qhp = this.Qhn.findViewById(c.f.live_tipsbar_title_icon);
      ho(this.Qhn);
    }
    String str3 = ((Bundle)localObject1).getString("key_brand_name");
    final String str1 = ((Bundle)localObject1).getString("key_brand_user_name");
    final String str2 = ((c)com.tencent.mm.kernel.h.ae(c.class)).apg(str1);
    if ((!Util.isNullOrNil(str2)) && (bb((Bundle)localObject1))) {}
    final boolean bool2;
    for (final boolean bool1 = true;; bool1 = false)
    {
      bool2 = ((Bundle)localObject1).getBoolean("key_current_info_show");
      Log.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s, isLiveNow:%b, show %b", new Object[] { str1, str3, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!Util.isNullOrNil(str3)) && (!Util.isNullOrNil(str1))) {
        break;
      }
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", new Object[] { str1, str3 });
      AppMethodBeat.o(175832);
      return;
    }
    this.QcD.setMMTitle("");
    this.Qhn.setVisibility(0);
    Object localObject2 = this.Qhp;
    label469:
    final int j;
    label579:
    int k;
    int m;
    if (bool1)
    {
      i = 0;
      ((View)localObject2).setVisibility(i);
      localObject2 = this.Qhr;
      if (!bool1) {
        break label750;
      }
      i = 8;
      ((View)localObject2).setVisibility(i);
      i = com.tencent.mm.ci.a.fromDPToPix(this.QcD, 4);
      j = this.QcD.getIntent().getIntExtra(f.r.VSJ, 0);
      if ((!bool1) || (bool2)) {
        break label755;
      }
      this.Qht.setText(this.QcD.getString(c.i.biz_time_line_finder_live_title));
      this.Qhq.setBackgroundResource(c.e.webview_top_bar_live_bg);
      this.Qht.setTextSize(1, 13.0F);
      ar.b(this.Qht.getPaint());
      this.Qhq.setPadding(i * 3, 0, i * 3, 0);
      aoG(i * 2);
      localObject1 = ((Bundle)localObject1).getString("key_url");
      if (bool1)
      {
        k = ((c)com.tencent.mm.kernel.h.ae(c.class)).aph(str1);
        str3 = bms((String)localObject1);
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        m = this.Qfr;
        if (!bool2) {
          break label843;
        }
      }
    }
    label843:
    for (int i = 3;; i = 2)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject2).a(23044, new Object[] { Integer.valueOf(1), str1, Integer.valueOf(m), Integer.valueOf(j), str2, Integer.valueOf(k), Integer.valueOf(i), str3 });
      this.Qho.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175828);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((p.this.QcD == null) || (p.this.QcD.Qgk == null))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175828);
            return;
          }
          if (SystemClock.elapsedRealtime() - p.a(p.this) < 175L)
          {
            p.b(p.this).removeCallbacksAndMessages(null);
            p.this.QcD.gYQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(175828);
            return;
          }
          p.a(p.this, SystemClock.elapsedRealtime());
          p.b(p.this).postDelayed(new Runnable()
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
              if (p.3.this.QhA)
              {
                j = ((c)com.tencent.mm.kernel.h.ae(c.class)).aph(p.3.this.iXL);
                localObject = com.tencent.mm.plugin.report.service.h.IzE;
                str1 = p.3.this.iXL;
                k = p.this.Qfr;
                m = p.3.this.QhB;
                str2 = p.3.this.QhC;
                if (!p.3.this.val$show) {
                  break label246;
                }
              }
              label246:
              for (int i = 3;; i = 2)
              {
                ((com.tencent.mm.plugin.report.service.h)localObject).a(23044, new Object[] { Integer.valueOf(2), str1, Integer.valueOf(k), Integer.valueOf(m), str2, Integer.valueOf(j), Integer.valueOf(i), p.a(p.this, p.3.this.val$url) });
                if ((!p.3.this.QhA) || (p.3.this.val$show)) {
                  break;
                }
                localObject = new Bundle();
                ((Bundle)localObject).putString("userName", p.3.this.iXL);
                ((Bundle)localObject).putString("exportId", p.3.this.QhC);
                XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject, p.c.class, null);
                AppMethodBeat.o(175827);
                return;
              }
              p.this.QcD.Qgk.hf("Contact_Scene", 154);
              p.this.QcD.bmo(p.3.this.iXL);
              if (p.this.QcD.PvJ != null)
              {
                localObject = p.this.QcD.PvJ;
                if (((com.tencent.mm.plugin.webview.d.h)localObject).NoX)
                {
                  str1 = n.a.b("topbar:click", null, ((com.tencent.mm.plugin.webview.d.h)localObject).PNx, ((com.tencent.mm.plugin.webview.d.h)localObject).EVx);
                  ((com.tencent.mm.plugin.webview.d.h)localObject).PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str1 + ")", null);
                }
              }
              p.b(p.this).removeCallbacksAndMessages(null);
              AppMethodBeat.o(175827);
            }
          }, 175L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
        }
      });
      com.tencent.mm.ui.tools.p.E(this.Qho, 0.7F);
      AppMethodBeat.o(175832);
      return;
      i = 8;
      break;
      label750:
      i = 4;
      break label469;
      label755:
      this.Qht.setText(l.b(this.QcD, str3, this.Qht.getTextSize()));
      this.Qhq.setBackgroundResource(c.c.transparent);
      this.Qht.setTextSize(1, 17.0F);
      ar.a(this.Qht.getPaint(), 0.8F);
      this.Qhq.setPadding(i * 2, 0, i * 2, 0);
      aoG(com.tencent.mm.ci.a.fromDPToPix(this.QcD, 10));
      break label579;
    }
  }
  
  public final void gZz()
  {
    AppMethodBeat.i(175833);
    this.QcD.getController().setMMTitleVisibility(0);
    if (this.Qhn != null) {
      this.Qhn.setVisibility(8);
    }
    gZt();
    AppMethodBeat.o(175833);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(215745);
    if ((this.Hgr == null) && (gZs()))
    {
      this.Hgr = new a(this);
      this.Hgr.alive();
    }
    AppMethodBeat.o(215745);
  }
  
  static final class a
    extends IListener<ap>
  {
    private WeakReference<p> Hgy;
    
    public a(p paramp)
    {
      AppMethodBeat.i(265166);
      this.Hgy = new WeakReference(paramp);
      this.__eventId = ap.class.getName().hashCode();
      AppMethodBeat.o(265166);
    }
  }
  
  public static final class b
  {
    public boolean PYi;
    public String QhF;
    public String QhG;
    public String lFl;
    public String lpK;
    public String title;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!Util.isNullOrNil(this.QhG)) && (!Util.isNullOrNil(this.QhF)) && (!Util.isNullOrNil(this.lFl)) && (this.PYi))
      {
        AppMethodBeat.o(175829);
        return true;
      }
      AppMethodBeat.o(175829);
      return false;
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static final class c
    implements d<Bundle, Object>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */