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
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class n
{
  static Map<String, Bundle> Bfd;
  boolean BiN;
  WebViewUI BiO;
  View BiP;
  private View BiQ;
  private TextView BiR;
  private long BiS;
  private ap handler;
  String lst;
  MMWebView uQx;
  private final long xFP;
  
  static
  {
    AppMethodBeat.i(175837);
    Bfd = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public n(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.BiN = false;
    this.handler = new ap(Looper.getMainLooper());
    this.BiP = null;
    this.BiQ = null;
    this.BiR = null;
    this.BiS = SystemClock.elapsedRealtime();
    this.xFP = 175L;
    this.BiO = paramWebViewUI;
    AppMethodBeat.o(175830);
  }
  
  static String Pa(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (g.ab(b.class) == null) || (!((b)g.ab(b.class)).isMpUrl(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((b)g.ab(b.class)).Pa(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  public static a ayb(String paramString)
  {
    AppMethodBeat.i(175835);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = Pa(paramString);
    Object localObject = (Bundle)Bfd.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = ((Bundle)localObject).getString("key_brand_name");
    String str1 = ((Bundle)localObject).getString("key_brand_user_name");
    String str2 = ((Bundle)localObject).getString("key_bag_icon");
    boolean bool = ((Bundle)localObject).getBoolean("key_show_menu_onfo", false);
    localObject = new a();
    ((a)localObject).BiW = str2;
    ((a)localObject).BiV = paramString;
    ((a)localObject).gXY = str1;
    ((a)localObject).BaH = bool;
    AppMethodBeat.o(175835);
    return localObject;
  }
  
  @SuppressLint({"ResourceType"})
  private void epg()
  {
    AppMethodBeat.i(80403);
    View localView = this.BiO.findViewById(2131306922);
    if (localView != null) {
      localView.setBackgroundColor(epk());
    }
    int i = this.BiO.getResources().getColor(2131101168);
    localView = this.BiO.findViewById(2131307119);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.BiO.findViewById(2131301014);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.BiO.findViewById(2131307118);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(2131691440);
    }
    AppMethodBeat.o(80403);
  }
  
  private void eph()
  {
    AppMethodBeat.i(80404);
    int i = epk();
    this.BiO.setActionbarColor(i);
    this.BiO.showActionbarLine();
    AppMethodBeat.o(80404);
  }
  
  private boolean epj()
  {
    AppMethodBeat.i(80406);
    if (this.BiO == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.lst;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = this.BiO.bEx();
    }
    boolean bool = com.tencent.mm.plugin.webview.j.i.ayM(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final void aG(final Bundle paramBundle)
  {
    AppMethodBeat.i(175831);
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175825);
        if ((n.a(n.this) == null) || (n.a(n.this).isFinishing()))
        {
          AppMethodBeat.o(175825);
          return;
        }
        boolean bool = paramBundle.getBoolean("key_current_info_show");
        Bundle localBundle = (Bundle)n.Xw().get(n.ayc(n.b(n.this)));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if (bool)
        {
          n.this.epl();
          AppMethodBeat.o(175825);
          return;
        }
        n.this.epm();
        AppMethodBeat.o(175825);
      }
    };
    h.Iye.aN(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  final boolean epe()
  {
    AppMethodBeat.i(80401);
    if (this.BiO.bon())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.BiO.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getBooleanExtra("disable_light_actionbar_style", false))
      {
        ad.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
        AppMethodBeat.o(80401);
        return true;
      }
      String str = localIntent.getStringExtra("status_bar_style");
      if ((!bt.isNullOrNil(str)) && (str.equals("black")))
      {
        ad.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getIntExtra("customize_status_bar_color", 0) != 0)
      {
        ad.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("open_custom_style_url", false))
      {
        ad.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("show_full_screen", false))
      {
        ad.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
        AppMethodBeat.o(80401);
        return true;
      }
    }
    AppMethodBeat.o(80401);
    return false;
  }
  
  final void epf()
  {
    AppMethodBeat.i(80402);
    eph();
    epg();
    epi();
    AppMethodBeat.o(80402);
  }
  
  final void epi()
  {
    AppMethodBeat.i(80405);
    if (!epj())
    {
      this.BiO.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    if ((this.uQx != null) && (this.uQx.getWebScrollY() > 0))
    {
      this.BiO.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    this.BiO.hideActionbarLine();
    AppMethodBeat.o(80405);
  }
  
  public final int epk()
  {
    AppMethodBeat.i(80407);
    if (epj())
    {
      i = this.BiO.getResources().getColor(2131101167);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.BiO.getResources().getColor(2131101161);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void epl()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)Bfd.get(Pa(this.lst));
    if ((localObject1 == null) || (this.BiO == null))
    {
      ad.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.lst });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.BiO.BgD)
    {
      ad.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    this.BiO.getController().setMMTitleVisibility(8);
    if (this.BiP == null)
    {
      this.BiP = this.BiO.getLayoutInflater().inflate(2131496092, null);
      this.BiQ = this.BiP.findViewById(2131306927);
      this.BiR = ((TextView)this.BiP.findViewById(2131302867));
      this.BiR.setTextSize(1, 17.0F);
      ((LinearLayout)this.BiO.getController().mActionBar.getCustomView()).addView(this.BiP);
      localObject2 = (LinearLayout.LayoutParams)this.BiP.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      this.BiP.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    Object localObject2 = ((Bundle)localObject1).getString("key_brand_name");
    localObject1 = ((Bundle)localObject1).getString("key_brand_user_name");
    ad.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s", new Object[] { localObject1, localObject2 });
    if ((bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject1)))
    {
      ad.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", new Object[] { localObject1, localObject2 });
      AppMethodBeat.o(175832);
      return;
    }
    this.BiO.setMMTitle("");
    if (this.BiP.getVisibility() == 8) {
      this.BiP.setVisibility(4);
    }
    this.BiR.setText(k.b(this.BiO, (CharSequence)localObject2, this.BiR.getTextSize()));
    ai.a(this.BiR.getPaint(), 0.8F);
    this.BiP.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175826);
        float f1 = n.c(n.this).getX();
        int i = (int)(n.c(n.this).getWidth() / 2 + f1);
        int j = a.hV(n.a(n.this)) / 2;
        if (i != j)
        {
          float f2 = j - i + f1;
          n.c(n.this).setX(f2);
          ad.d("MicroMsg.WebViewUIStyleHelper", "showTopBar x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        }
        if (n.c(n.this).getVisibility() != 0) {
          n.c(n.this).setVisibility(0);
        }
        AppMethodBeat.o(175826);
      }
    });
    this.BiQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175828);
        if ((n.a(n.this) == null) || (n.a(n.this).BhW == null))
        {
          AppMethodBeat.o(175828);
          return;
        }
        if (SystemClock.elapsedRealtime() - n.d(n.this) < 175L)
        {
          n.e(n.this).removeCallbacksAndMessages(null);
          n.a(n.this).eoH();
          AppMethodBeat.o(175828);
          return;
        }
        n.a(n.this, SystemClock.elapsedRealtime());
        n.e(n.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175827);
            n.a(n.this).BhW.fk("Contact_Scene", 154);
            n.a(n.this).axZ(n.3.this.gXD);
            if (n.a(n.this).AQP != null)
            {
              f localf = n.a(n.this).AQP;
              if (localf.yZR)
              {
                String str = l.a.b("topbar:click", null, localf.ARm, localf.ARn);
                localf.ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
              }
            }
            n.e(n.this).removeCallbacksAndMessages(null);
            AppMethodBeat.o(175827);
          }
        }, 175L);
        AppMethodBeat.o(175828);
      }
    });
    o.gp(this.BiQ);
    AppMethodBeat.o(175832);
  }
  
  public final void epm()
  {
    AppMethodBeat.i(175833);
    this.BiO.getController().setMMTitleVisibility(0);
    if (this.BiP != null) {
      this.BiP.setVisibility(8);
    }
    AppMethodBeat.o(175833);
  }
  
  public static final class a
  {
    public boolean BaH;
    public String BiV;
    public String BiW;
    public String gXY;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!bt.isNullOrNil(this.BiW)) && (!bt.isNullOrNil(this.BiV)) && (!bt.isNullOrNil(this.gXY)) && (this.BaH))
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n
 * JD-Core Version:    0.7.0.1
 */