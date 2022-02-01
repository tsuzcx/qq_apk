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
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

public final class n
{
  static Map<String, Bundle> Cxp;
  boolean CBa;
  WebViewUI CBb;
  View CBc;
  private View CBd;
  private TextView CBe;
  private long CBf;
  MMWebView gGd;
  private ao handler;
  String lUn;
  private final long ySC;
  
  static
  {
    AppMethodBeat.i(175837);
    Cxp = new HashMap();
    AppMethodBeat.o(175837);
  }
  
  public n(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(175830);
    this.CBa = false;
    this.handler = new ao(Looper.getMainLooper());
    this.CBc = null;
    this.CBd = null;
    this.CBe = null;
    this.CBf = SystemClock.elapsedRealtime();
    this.ySC = 175L;
    this.CBb = paramWebViewUI;
    AppMethodBeat.o(175830);
  }
  
  static String Tk(String paramString)
  {
    AppMethodBeat.i(175834);
    if ((paramString == null) || (g.ab(b.class) == null) || (!((b)g.ab(b.class)).Tg(paramString)))
    {
      AppMethodBeat.o(175834);
      return paramString;
    }
    paramString = ((b)g.ab(b.class)).Tk(paramString);
    AppMethodBeat.o(175834);
    return paramString;
  }
  
  public static a aDs(String paramString)
  {
    AppMethodBeat.i(175835);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(175835);
      return null;
    }
    paramString = Tk(paramString);
    Object localObject = (Bundle)Cxp.get(paramString);
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
    ((a)localObject).CBj = str2;
    ((a)localObject).CBi = paramString;
    ((a)localObject).hyx = str1;
    ((a)localObject).CsU = bool;
    AppMethodBeat.o(175835);
    return localObject;
  }
  
  @SuppressLint({"ResourceType"})
  private void eEB()
  {
    AppMethodBeat.i(80403);
    View localView = this.CBb.findViewById(2131306922);
    if (localView != null) {
      localView.setBackgroundColor(eEF());
    }
    int i = this.CBb.getResources().getColor(2131101168);
    localView = this.CBb.findViewById(2131307119);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.CBb.findViewById(2131301014);
    if ((localView != null) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(i);
    }
    localView = this.CBb.findViewById(2131307118);
    if ((localView != null) && ((localView instanceof ImageView))) {
      ((ImageView)localView).setImageResource(2131691440);
    }
    AppMethodBeat.o(80403);
  }
  
  private void eEC()
  {
    AppMethodBeat.i(80404);
    int i = eEF();
    this.CBb.setActionbarColor(i);
    this.CBb.showActionbarLine();
    AppMethodBeat.o(80404);
  }
  
  private boolean eEE()
  {
    AppMethodBeat.i(80406);
    if (this.CBb == null)
    {
      AppMethodBeat.o(80406);
      return false;
    }
    String str2 = this.lUn;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = this.CBb.bLL();
    }
    boolean bool = com.tencent.mm.plugin.webview.j.i.aEd(str1);
    AppMethodBeat.o(80406);
    return bool;
  }
  
  public final void aL(final Bundle paramBundle)
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
        Bundle localBundle = (Bundle)n.Yt().get(n.aDt(n.b(n.this)));
        if (localBundle != null) {
          localBundle.putBoolean("key_current_info_show", bool);
        }
        if (bool)
        {
          n.this.eEG();
          AppMethodBeat.o(175825);
          return;
        }
        n.this.eEH();
        AppMethodBeat.o(175825);
      }
    };
    h.JZN.aQ(paramBundle);
    AppMethodBeat.o(175831);
  }
  
  final void eEA()
  {
    AppMethodBeat.i(80402);
    eEC();
    eEB();
    eED();
    AppMethodBeat.o(80402);
  }
  
  final void eED()
  {
    AppMethodBeat.i(80405);
    if (!eEE())
    {
      this.CBb.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    if ((this.gGd != null) && (this.gGd.getWebScrollY() > 0))
    {
      this.CBb.showActionbarLine();
      AppMethodBeat.o(80405);
      return;
    }
    this.CBb.hideActionbarLine();
    AppMethodBeat.o(80405);
  }
  
  public final int eEF()
  {
    AppMethodBeat.i(80407);
    if (eEE())
    {
      i = this.CBb.getResources().getColor(2131101167);
      AppMethodBeat.o(80407);
      return i;
    }
    int i = this.CBb.getResources().getColor(2131101161);
    AppMethodBeat.o(80407);
    return i;
  }
  
  public final void eEG()
  {
    AppMethodBeat.i(175832);
    Object localObject1 = (Bundle)Cxp.get(Tk(this.lUn));
    if ((localObject1 == null) || (this.CBb == null))
    {
      ac.w("MicroMsg.WebViewUIStyleHelper", "showTopBar not ready %s", new Object[] { this.lUn });
      AppMethodBeat.o(175832);
      return;
    }
    if (this.CBb.CyP)
    {
      ac.i("MicroMsg.WebViewUIStyleHelper", "fixedTitle not show topbar");
      AppMethodBeat.o(175832);
      return;
    }
    this.CBb.getController().setMMTitleVisibility(8);
    if (this.CBc == null)
    {
      this.CBc = this.CBb.getLayoutInflater().inflate(2131496092, null);
      this.CBd = this.CBc.findViewById(2131306927);
      this.CBe = ((TextView)this.CBc.findViewById(2131302867));
      this.CBe.setTextSize(1, 17.0F);
      ((LinearLayout)this.CBb.getController().mActionBar.getCustomView()).addView(this.CBc);
      localObject2 = (LinearLayout.LayoutParams)this.CBc.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).width = -1;
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      this.CBc.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    Object localObject2 = ((Bundle)localObject1).getString("key_brand_name");
    localObject1 = ((Bundle)localObject1).getString("key_brand_user_name");
    ac.i("MicroMsg.WebViewUIStyleHelper", "showTopBar userName:%s, nickName:%s", new Object[] { localObject1, localObject2 });
    if ((bs.isNullOrNil((String)localObject2)) || (bs.isNullOrNil((String)localObject1)))
    {
      ac.w("MicroMsg.WebViewUIStyleHelper", "showTopBar invalid param, userName %s, nickName %s", new Object[] { localObject1, localObject2 });
      AppMethodBeat.o(175832);
      return;
    }
    this.CBb.setMMTitle("");
    if (this.CBc.getVisibility() == 8) {
      this.CBc.setVisibility(4);
    }
    this.CBe.setText(k.b(this.CBb, (CharSequence)localObject2, this.CBe.getTextSize()));
    aj.a(this.CBe.getPaint(), 0.8F);
    this.CBc.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(175826);
        float f1 = n.c(n.this).getX();
        int i = (int)(n.c(n.this).getWidth() / 2 + f1);
        int j = a.ig(n.a(n.this)) / 2;
        if (i != j)
        {
          float f2 = j - i + f1;
          n.c(n.this).setX(f2);
          ac.d("MicroMsg.WebViewUIStyleHelper", "showTopBar x = %f, new x=%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        }
        if (n.c(n.this).getVisibility() != 0) {
          n.c(n.this).setVisibility(0);
        }
        AppMethodBeat.o(175826);
      }
    });
    this.CBd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175828);
        if ((n.a(n.this) == null) || (n.a(n.this).CAj == null))
        {
          AppMethodBeat.o(175828);
          return;
        }
        if (SystemClock.elapsedRealtime() - n.d(n.this) < 175L)
        {
          n.e(n.this).removeCallbacksAndMessages(null);
          n.a(n.this).eEc();
          AppMethodBeat.o(175828);
          return;
        }
        n.a(n.this, SystemClock.elapsedRealtime());
        n.e(n.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175827);
            n.a(n.this).CAj.fs("Contact_Scene", 154);
            n.a(n.this).aDq(n.3.this.hyc);
            if (n.a(n.this).Cjc != null)
            {
              f localf = n.a(n.this).Cjc;
              if (localf.Apr)
              {
                String str = l.a.b("topbar:click", null, localf.Cjz, localf.CjA);
                localf.Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + str + ")", null);
              }
            }
            n.e(n.this).removeCallbacksAndMessages(null);
            AppMethodBeat.o(175827);
          }
        }, 175L);
        AppMethodBeat.o(175828);
      }
    });
    o.gD(this.CBd);
    AppMethodBeat.o(175832);
  }
  
  public final void eEH()
  {
    AppMethodBeat.i(175833);
    this.CBb.getController().setMMTitleVisibility(0);
    if (this.CBc != null) {
      this.CBc.setVisibility(8);
    }
    AppMethodBeat.o(175833);
  }
  
  final boolean eEz()
  {
    AppMethodBeat.i(80401);
    if (this.CBb.bvj())
    {
      AppMethodBeat.o(80401);
      return true;
    }
    Intent localIntent = this.CBb.getIntent();
    if (localIntent != null)
    {
      if (localIntent.getBooleanExtra("disable_light_actionbar_style", false))
      {
        ac.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, KDisableLightActionbarStyle is true");
        AppMethodBeat.o(80401);
        return true;
      }
      String str = localIntent.getStringExtra("status_bar_style");
      if ((!bs.isNullOrNil(str)) && (str.equals("black")))
      {
        ac.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KStatusBarStyle");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getIntExtra("customize_status_bar_color", 0) != 0)
      {
        ac.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KCustomizeStatusBarColor");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("open_custom_style_url", false))
      {
        ac.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, customized by KOpenCustomStyleUrl");
        AppMethodBeat.o(80401);
        return true;
      }
      if (localIntent.getBooleanExtra("show_full_screen", false))
      {
        ac.i("MicroMsg.WebViewUIStyleHelper", "checkDisableLightActionbarStyle, webview is fullscreen");
        AppMethodBeat.o(80401);
        return true;
      }
    }
    AppMethodBeat.o(80401);
    return false;
  }
  
  public static final class a
  {
    public String CBi;
    public String CBj;
    public boolean CsU;
    public String hyx;
    
    public final boolean isDataValid()
    {
      AppMethodBeat.i(175829);
      if ((!bs.isNullOrNil(this.CBj)) && (!bs.isNullOrNil(this.CBi)) && (!bs.isNullOrNil(this.hyx)) && (this.CsU))
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