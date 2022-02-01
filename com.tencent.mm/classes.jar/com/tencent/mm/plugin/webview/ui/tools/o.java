package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class o
{
  static Map<String, Bundle> Jgg;
  private final long EKO;
  boolean Jkf;
  WebViewUI Jkg;
  View Jkh;
  private View Jki;
  private TextView Jkj;
  private long Jkk;
  private MMHandler handler;
  String nKc;
  MMWebView webView;
  
  static
  {
    AppMethodBeat.i(175837);
    Jgg = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public o(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.Jkf = false;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Jkh = null;
    this.Jki = null;
    this.Jkj = null;
    this.Jkk = SystemClock.elapsedRealtime();
    this.EKO = 175L;
    this.Jkg = paramWebViewUI;
    AppMethodBeat.o(175830);
  }
  
  static String ahz(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (g.af(com.tencent.mm.plugin.brandservice.a.b.class) == null) || (!((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahz(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  public static a baw(String paramString)
  {
    AppMethodBeat.i(175835);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = ahz(paramString);
    Object localObject = (Bundle)Jgg.get(paramString);
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
    localObject = new a();
    ((a)localObject).Jko = paramString;
    ((a)localObject).Jkn = str2;
    ((a)localObject).brandUsername = str3;
    ((a)localObject).JbC = bool;
    ((a)localObject).title = str4;
    if (Util.isNullOrNil(str1)) {}
    for (;;)
    {
      ((a)localObject).iAo = paramString;
      AppMethodBeat.o(175835);
      return localObject;
      paramString = str1;
    }
  }
  
  @SuppressLint({"ResourceType"})
  private void ggf()
  {
    AppMethodBeat.i(80403);
    View localView = this.Jkg.findViewById(2131310395);
    if (localView != null) {
      localView.setBackgroundColor(ggj());
    }
    int i = this.Jkg.getResources().getColor(2131101411);
    localView = this.Jkg.findViewById(2131310659);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.Jkg.findViewById(2131302658);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.Jkg.findViewById(2131310658);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(2131691778);
    }
    AppMethodBeat.o(80403);
  }
  
  private void ggg()
  {
    AppMethodBeat.i(80404);
    int i = ggj();
    this.Jkg.setActionbarColor(i);
    this.Jkg.showActionbarLine();
    AppMethodBeat.o(80404);
  }
  
  private boolean ggi()
  {
    AppMethodBeat.i(80406);
    if (this.Jkg == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.nKc;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = this.Jkg.coX();
    }
    boolean bool = k.bbr(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final void bd(final Bundle paramBundle)
  {
    AppMethodBeat.i(175831);
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175825);
        if ((o.a(o.this) == null) || (o.a(o.this).isFinishing()))
        {
          AppMethodBeat.o(175825);
          return;
        }
        boolean bool = paramBundle.getBoolean("key_current_info_show");
        Bundle localBundle = (Bundle)o.apd().get(o.bax(o.b(o.this)));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if (bool)
        {
          o.this.ggl();
          AppMethodBeat.o(175825);
          return;
        }
        o.this.ggm();
        AppMethodBeat.o(175825);
      }
    };
    com.tencent.f.h.RTc.aV(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  final boolean ggd()
  {
    AppMethodBeat.i(80401);
    if (this.Jkg.bXi())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.Jkg.getIntent();
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
  
  final void gge()
  {
    AppMethodBeat.i(80402);
    ggg();
    ggf();
    ggh();
    AppMethodBeat.o(80402);
  }
  
  public final void ggh()
  {
    AppMethodBeat.i(80405);
    if (!ggi())
    {
      this.Jkg.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    if ((this.webView != null) && (this.webView.getWebScrollY() > 0))
    {
      this.Jkg.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    this.Jkg.hideActionbarLine();
    AppMethodBeat.o(80405);
  }
  
  public final int ggj()
  {
    AppMethodBeat.i(80407);
    if (ggi())
    {
      i = this.Jkg.getResources().getColor(2131101410);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.Jkg.getResources().getColor(2131101404);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void ggk()
  {
    AppMethodBeat.i(211199);
    Bundle localBundle = (Bundle)Jgg.get(ahz(this.nKc));
    if ((localBundle == null) || (this.Jkg == null))
    {
      ggm();
      AppMethodBeat.o(211199);
      return;
    }
    if (localBundle.getBoolean("key_current_info_show"))
    {
      ggl();
      AppMethodBeat.o(211199);
      return;
    }
    ggm();
    AppMethodBeat.o(211199);
  }
  
  public final void ggl()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)Jgg.get(ahz(this.nKc));
    if ((localObject1 == null) || (this.Jkg == null))
    {
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.nKc });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.Jkg.JhT)
    {
      Log.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    this.Jkg.getController().setMMTitleVisibility(8);
    Object localObject2;
    if (this.Jkh == null)
    {
      this.Jkh = this.Jkg.getLayoutInflater().inflate(2131497080, null);
      this.Jki = this.Jkh.findViewById(2131310401);
      this.Jkj = ((TextView)this.Jkh.findViewById(2131305440));
      this.Jkj.setTextSize(1, 17.0F);
      localObject2 = this.Jkg.getController().mActionBar.getCustomView();
      if (!(localObject2 instanceof LinearLayout)) {
        break label311;
      }
      ((LinearLayout)localObject2).addView(this.Jkh);
      localObject2 = (LinearLayout.LayoutParams)this.Jkh.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      this.Jkh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      localObject2 = ((Bundle)localObject1).getString("key_brand_name");
      localObject1 = ((Bundle)localObject1).getString("key_brand_user_name");
      Log.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s", new Object[] { localObject1, localObject2 });
      if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil((String)localObject1))) {
        break;
      }
      Log.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", new Object[] { localObject1, localObject2 });
      AppMethodBeat.o(175832);
      return;
      label311:
      if ((localObject2 instanceof RelativeLayout))
      {
        ((RelativeLayout)localObject2).addView(this.Jkh);
        localObject2 = (RelativeLayout.LayoutParams)this.Jkh.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = -1;
        ((RelativeLayout.LayoutParams)localObject2).height = -1;
        this.Jkh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    this.Jkg.setMMTitle("");
    if (this.Jkh.getVisibility() == 8) {
      this.Jkh.setVisibility(4);
    }
    this.Jkj.setText(l.b(this.Jkg, (CharSequence)localObject2, this.Jkj.getTextSize()));
    ao.a(this.Jkj.getPaint(), 0.8F);
    this.Jkh.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175826);
        float f1 = o.c(o.this).getX();
        int i = (int)(o.c(o.this).getWidth() / 2 + f1);
        int j = com.tencent.mm.cb.a.jn(o.a(o.this)) / 2;
        if (i != j)
        {
          float f2 = j - i + f1;
          o.c(o.this).setX(f2);
          Log.d("MicroMsg.WebViewUIStyleHelper", "showTopBar x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        }
        if (o.c(o.this).getVisibility() != 0) {
          o.c(o.this).setVisibility(0);
        }
        AppMethodBeat.o(175826);
      }
    });
    this.Jki.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((o.a(o.this) == null) || (o.a(o.this).Jjm == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
          return;
        }
        if (SystemClock.elapsedRealtime() - o.d(o.this) < 175L)
        {
          o.e(o.this).removeCallbacksAndMessages(null);
          o.a(o.this).gfF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
          return;
        }
        o.a(o.this, SystemClock.elapsedRealtime());
        o.e(o.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175827);
            o.a(o.this).Jjm.gx("Contact_Scene", 154);
            o.a(o.this).bas(o.3.this.gtz);
            if (o.a(o.this).IBw != null)
            {
              com.tencent.mm.plugin.webview.d.h localh = o.a(o.this).IBw;
              if (localh.GBl)
              {
                String str = n.a.b("topbar:click", null, localh.IRj, localh.zpY);
                localh.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
              }
            }
            o.e(o.this).removeCallbacksAndMessages(null);
            AppMethodBeat.o(175827);
          }
        }, 175L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175828);
      }
    });
    com.tencent.mm.ui.tools.o.hq(this.Jki);
    AppMethodBeat.o(175832);
  }
  
  public final void ggm()
  {
    AppMethodBeat.i(175833);
    this.Jkg.getController().setMMTitleVisibility(0);
    if (this.Jkh != null) {
      this.Jkh.setVisibility(8);
    }
    AppMethodBeat.o(175833);
  }
  
  public static final class a
  {
    public boolean JbC;
    public String Jkn;
    public String Jko;
    public String brandUsername;
    public String iAo;
    public String title;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!Util.isNullOrNil(this.Jko)) && (!Util.isNullOrNil(this.Jkn)) && (!Util.isNullOrNil(this.brandUsername)) && (this.JbC))
      {
        AppMethodBeat.o(175829);
        return true;
      }
      AppMethodBeat.o(175829);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */