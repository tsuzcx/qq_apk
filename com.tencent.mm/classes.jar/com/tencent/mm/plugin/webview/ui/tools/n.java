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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class n
{
  static Map<String, Bundle> EaX;
  private final long Ake;
  boolean EeI;
  WebViewUI EeJ;
  View EeK;
  private View EeL;
  private TextView EeM;
  private long EeN;
  MMWebView gZN;
  private ap handler;
  String mue;
  
  static
  {
    AppMethodBeat.i(175837);
    EaX = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public n(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.EeI = false;
    this.handler = new ap(Looper.getMainLooper());
    this.EeK = null;
    this.EeL = null;
    this.EeM = null;
    this.EeN = SystemClock.elapsedRealtime();
    this.Ake = 175L;
    this.EeJ = paramWebViewUI;
    AppMethodBeat.o(175830);
  }
  
  static String WQ(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (g.ab(com.tencent.mm.plugin.brandservice.a.b.class) == null) || (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WQ(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  public static a aIT(String paramString)
  {
    AppMethodBeat.i(175835);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = WQ(paramString);
    Object localObject = (Bundle)EaX.get(paramString);
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
    ((a)localObject).EeR = str2;
    ((a)localObject).EeQ = paramString;
    ((a)localObject).hQR = str1;
    ((a)localObject).DWz = bool;
    AppMethodBeat.o(175835);
    return localObject;
  }
  
  @SuppressLint({"ResourceType"})
  private void eTt()
  {
    AppMethodBeat.i(80403);
    View localView = this.EeJ.findViewById(2131306922);
    if (localView != null) {
      localView.setBackgroundColor(eTx());
    }
    int i = this.EeJ.getResources().getColor(2131101168);
    localView = this.EeJ.findViewById(2131307119);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.EeJ.findViewById(2131301014);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.EeJ.findViewById(2131307118);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(2131691440);
    }
    AppMethodBeat.o(80403);
  }
  
  private void eTu()
  {
    AppMethodBeat.i(80404);
    int i = eTx();
    this.EeJ.setActionbarColor(i);
    this.EeJ.showActionbarLine();
    AppMethodBeat.o(80404);
  }
  
  private boolean eTw()
  {
    AppMethodBeat.i(80406);
    if (this.EeJ == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.mue;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = this.EeJ.bQm();
    }
    boolean bool = j.aJF(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final void aQ(final Bundle paramBundle)
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
        Bundle localBundle = (Bundle)n.aaV().get(n.aIU(n.b(n.this)));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if (bool)
        {
          n.this.eTy();
          AppMethodBeat.o(175825);
          return;
        }
        n.this.eTz();
        AppMethodBeat.o(175825);
      }
    };
    h.LTJ.aP(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  final boolean eTr()
  {
    AppMethodBeat.i(80401);
    if (this.EeJ.bzp())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.EeJ.getIntent();
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
  
  final void eTs()
  {
    AppMethodBeat.i(80402);
    eTu();
    eTt();
    eTv();
    AppMethodBeat.o(80402);
  }
  
  final void eTv()
  {
    AppMethodBeat.i(80405);
    if (!eTw())
    {
      this.EeJ.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    if ((this.gZN != null) && (this.gZN.getWebScrollY() > 0))
    {
      this.EeJ.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    this.EeJ.hideActionbarLine();
    AppMethodBeat.o(80405);
  }
  
  public final int eTx()
  {
    AppMethodBeat.i(80407);
    if (eTw())
    {
      i = this.EeJ.getResources().getColor(2131101167);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.EeJ.getResources().getColor(2131101161);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void eTy()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)EaX.get(WQ(this.mue));
    if ((localObject1 == null) || (this.EeJ == null))
    {
      ad.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.mue });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.EeJ.Ecy)
    {
      ad.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    this.EeJ.getController().setMMTitleVisibility(8);
    if (this.EeK == null)
    {
      this.EeK = this.EeJ.getLayoutInflater().inflate(2131496092, null);
      this.EeL = this.EeK.findViewById(2131306927);
      this.EeM = ((TextView)this.EeK.findViewById(2131302867));
      this.EeM.setTextSize(1, 17.0F);
      ((LinearLayout)this.EeJ.getController().mActionBar.getCustomView()).addView(this.EeK);
      localObject2 = (LinearLayout.LayoutParams)this.EeK.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      this.EeK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
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
    this.EeJ.setMMTitle("");
    if (this.EeK.getVisibility() == 8) {
      this.EeK.setVisibility(4);
    }
    this.EeM.setText(k.b(this.EeJ, (CharSequence)localObject2, this.EeM.getTextSize()));
    al.a(this.EeM.getPaint(), 0.8F);
    this.EeK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175826);
        float f1 = n.c(n.this).getX();
        int i = (int)(n.c(n.this).getWidth() / 2 + f1);
        int j = com.tencent.mm.cc.a.ip(n.a(n.this)) / 2;
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
    this.EeL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((n.a(n.this) == null) || (n.a(n.this).EdR == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(175828);
          return;
        }
        if (SystemClock.elapsedRealtime() - n.d(n.this) < 175L)
        {
          n.e(n.this).removeCallbacksAndMessages(null);
          n.a(n.this).eSU();
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
            n.a(n.this).EdR.fP("Contact_Scene", 154);
            n.a(n.this).aIR(n.3.this.fNT);
            if (n.a(n.this).DzP != null)
            {
              f localf = n.a(n.this).DzP;
              if (localf.BHY)
              {
                String str = l.a.b("topbar:click", null, localf.DMD, localf.vJP);
                localf.DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
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
    o.gU(this.EeL);
    AppMethodBeat.o(175832);
  }
  
  public final void eTz()
  {
    AppMethodBeat.i(175833);
    this.EeJ.getController().setMMTitleVisibility(0);
    if (this.EeK != null) {
      this.EeK.setVisibility(8);
    }
    AppMethodBeat.o(175833);
  }
  
  public static final class a
  {
    public boolean DWz;
    public String EeQ;
    public String EeR;
    public String hQR;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!bt.isNullOrNil(this.EeR)) && (!bt.isNullOrNil(this.EeQ)) && (!bt.isNullOrNil(this.hQR)) && (this.DWz))
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