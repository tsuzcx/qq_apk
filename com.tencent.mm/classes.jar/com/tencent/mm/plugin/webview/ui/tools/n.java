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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.j.j;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class n
{
  static Map<String, Bundle> EsY;
  private final long ABq;
  boolean EwK;
  WebViewUI EwL;
  private boolean EwM;
  View EwN;
  private View EwO;
  private TextView EwP;
  private long EwQ;
  private aq handler;
  MMWebView hcA;
  String mzb;
  
  static
  {
    AppMethodBeat.i(175837);
    EsY = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public n(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.EwK = false;
    this.EwM = false;
    this.handler = new aq(Looper.getMainLooper());
    this.EwN = null;
    this.EwO = null;
    this.EwP = null;
    this.EwQ = SystemClock.elapsedRealtime();
    this.ABq = 175L;
    this.EwL = paramWebViewUI;
    AppMethodBeat.o(175830);
  }
  
  static String XC(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (g.ab(com.tencent.mm.plugin.brandservice.a.b.class) == null) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XC(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  public static a aKm(String paramString)
  {
    AppMethodBeat.i(175835);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = XC(paramString);
    Object localObject = (Bundle)EsY.get(paramString);
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
    ((a)localObject).EwU = str2;
    ((a)localObject).EwT = paramString;
    ((a)localObject).hTJ = str1;
    ((a)localObject).Eoy = bool;
    AppMethodBeat.o(175835);
    return localObject;
  }
  
  @SuppressLint({"ResourceType"})
  private void eXg()
  {
    AppMethodBeat.i(80403);
    View localView = this.EwL.findViewById(2131306922);
    if (localView != null) {
      localView.setBackgroundColor(eXk());
    }
    int i = this.EwL.getResources().getColor(2131101168);
    localView = this.EwL.findViewById(2131307119);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.EwL.findViewById(2131301014);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.EwL.findViewById(2131307118);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(2131691440);
    }
    AppMethodBeat.o(80403);
  }
  
  private void eXh()
  {
    AppMethodBeat.i(80404);
    int i = eXk();
    this.EwL.setActionbarColor(i);
    this.EwL.showActionbarLine();
    AppMethodBeat.o(80404);
  }
  
  private boolean eXj()
  {
    AppMethodBeat.i(80406);
    if (this.EwL == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.mzb;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = this.EwL.bRn();
    }
    boolean bool = j.aLb(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final void aR(final Bundle paramBundle)
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
        Bundle localBundle = (Bundle)n.abe().get(n.aKn(n.b(n.this)));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if (bool)
        {
          n.this.eXl();
          AppMethodBeat.o(175825);
          return;
        }
        n.this.eXm();
        AppMethodBeat.o(175825);
      }
    };
    h.MqF.aM(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  final boolean eXe()
  {
    AppMethodBeat.i(80401);
    if (this.EwL.bAk())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.EwL.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getBooleanExtra("disable_light_actionbar_style", false))
      {
        ae.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
        AppMethodBeat.o(80401);
        return true;
      }
      String str = localIntent.getStringExtra("status_bar_style");
      if ((!bu.isNullOrNil(str)) && (str.equals("black")))
      {
        ae.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getIntExtra("customize_status_bar_color", 0) != 0)
      {
        ae.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("open_custom_style_url", false))
      {
        ae.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("show_full_screen", false))
      {
        ae.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
        AppMethodBeat.o(80401);
        return true;
      }
    }
    AppMethodBeat.o(80401);
    return false;
  }
  
  final void eXf()
  {
    AppMethodBeat.i(80402);
    eXh();
    eXg();
    eXi();
    AppMethodBeat.o(80402);
  }
  
  public final void eXi()
  {
    AppMethodBeat.i(80405);
    if (!eXj())
    {
      if (!this.EwM)
      {
        this.EwL.showActionbarLine();
        AppMethodBeat.o(80405);
      }
    }
    else if ((this.hcA != null) && (this.hcA.getWebScrollY() > 0))
    {
      if (!this.EwM)
      {
        this.EwL.showActionbarLine();
        AppMethodBeat.o(80405);
      }
    }
    else {
      this.EwL.hideActionbarLine();
    }
    AppMethodBeat.o(80405);
  }
  
  public final int eXk()
  {
    AppMethodBeat.i(80407);
    if (eXj())
    {
      i = this.EwL.getResources().getColor(2131101167);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.EwL.getResources().getColor(2131101161);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void eXl()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)EsY.get(XC(this.mzb));
    if ((localObject1 == null) || (this.EwL == null))
    {
      ae.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.mzb });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.EwL.EuA)
    {
      ae.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    this.EwL.getController().setMMTitleVisibility(8);
    if (this.EwN == null)
    {
      this.EwN = this.EwL.getLayoutInflater().inflate(2131496092, null);
      this.EwO = this.EwN.findViewById(2131306927);
      this.EwP = ((TextView)this.EwN.findViewById(2131302867));
      this.EwP.setTextSize(1, 17.0F);
      ((LinearLayout)this.EwL.getController().mActionBar.getCustomView()).addView(this.EwN);
      localObject2 = (LinearLayout.LayoutParams)this.EwN.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      this.EwN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    Object localObject2 = ((Bundle)localObject1).getString("key_brand_name");
    localObject1 = ((Bundle)localObject1).getString("key_brand_user_name");
    ae.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s", new Object[] { localObject1, localObject2 });
    if ((bu.isNullOrNil((String)localObject2)) || (bu.isNullOrNil((String)localObject1)))
    {
      ae.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", new Object[] { localObject1, localObject2 });
      AppMethodBeat.o(175832);
      return;
    }
    this.EwL.setMMTitle("");
    if (this.EwN.getVisibility() == 8) {
      this.EwN.setVisibility(4);
    }
    this.EwP.setText(k.b(this.EwL, (CharSequence)localObject2, this.EwP.getTextSize()));
    al.a(this.EwP.getPaint(), 0.8F);
    this.EwN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175826);
        float f1 = n.c(n.this).getX();
        int i = (int)(n.c(n.this).getWidth() / 2 + f1);
        int j = com.tencent.mm.cb.a.iu(n.a(n.this)) / 2;
        if (i != j)
        {
          float f2 = j - i + f1;
          n.c(n.this).setX(f2);
          ae.d("MicroMsg.WebViewUIStyleHelper", "showTopBar x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        }
        if (n.c(n.this).getVisibility() != 0) {
          n.c(n.this).setVisibility(0);
        }
        AppMethodBeat.o(175826);
      }
    });
    this.EwO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((n.a(n.this) == null) || (n.a(n.this).EvT == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
          return;
        }
        if (SystemClock.elapsedRealtime() - n.d(n.this) < 175L)
        {
          n.e(n.this).removeCallbacksAndMessages(null);
          n.a(n.this).eWH();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
          return;
        }
        n.a(n.this, SystemClock.elapsedRealtime());
        n.e(n.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175827);
            n.a(n.this).EvT.fZ("Contact_Scene", 154);
            n.a(n.this).aKk(n.3.this.fOp);
            if (n.a(n.this).DRx != null)
            {
              f localf = n.a(n.this).DRx;
              if (localf.BZx)
              {
                String str = l.a.b("topbar:click", null, localf.EeC, localf.vVT);
                localf.Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
              }
            }
            n.e(n.this).removeCallbacksAndMessages(null);
            AppMethodBeat.o(175827);
          }
        }, 175L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175828);
      }
    });
    o.gZ(this.EwO);
    AppMethodBeat.o(175832);
  }
  
  public final void eXm()
  {
    AppMethodBeat.i(175833);
    this.EwL.getController().setMMTitleVisibility(0);
    if (this.EwN != null) {
      this.EwN.setVisibility(8);
    }
    AppMethodBeat.o(175833);
  }
  
  public final void vr(boolean paramBoolean)
  {
    this.EwM = paramBoolean;
  }
  
  public static final class a
  {
    public boolean Eoy;
    public String EwT;
    public String EwU;
    public String hTJ;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!bu.isNullOrNil(this.EwU)) && (!bu.isNullOrNil(this.EwT)) && (!bu.isNullOrNil(this.hTJ)) && (this.Eoy))
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