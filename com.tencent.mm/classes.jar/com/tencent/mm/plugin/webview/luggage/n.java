package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONArray;
import org.json.JSONObject;

public class n
  extends FrameLayout
{
  private ImageView ImI;
  private int KIE;
  private View PVa;
  private g WFG;
  public com.tencent.mm.ui.statusbar.b WGV;
  public RelativeLayout WGW;
  private View WGX;
  private ImageView WGY;
  protected LinearLayout WGZ;
  private TextView WHa;
  private p WHb;
  protected com.tencent.mm.plugin.webview.luggage.b.n WHc;
  private y WHd;
  public e WHe;
  private boolean WHf;
  private int WHg;
  private boolean WHh;
  private boolean WHi;
  int WHj;
  private boolean WHk;
  public Integer WHl;
  public boolean WHm;
  private View.OnClickListener WHn;
  protected Context mContext;
  private String mTitle;
  public TextView sUt;
  private ImageView ugB;
  
  public n(g paramg)
  {
    super(paramg.mContext);
    AppMethodBeat.i(78384);
    this.WHe = null;
    this.WHf = false;
    this.WHj = -1;
    this.KIE = c.h.actionbar_quit_webview_icon;
    this.WHk = false;
    this.WHn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(295873);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (n.a(n.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(295873);
          return;
        }
        n.a(n.this).ejR.a(new d()
        {
          public final JSONObject aoe()
          {
            AppMethodBeat.i(295899);
            JSONObject localJSONObject = new JSONObject();
            AppMethodBeat.o(295899);
            return localJSONObject;
          }
          
          public final String name()
          {
            return "onNavigationBarRightButtonClick";
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(295873);
      }
    };
    setId(c.f.luggage_action_bar);
    this.mContext = paramg.mContext;
    this.WFG = paramg;
    setBackgroundColor(0);
    this.WGV = new c(this.mContext);
    addView(this.WGV, -1, -1);
    this.WHg = androidx.core.content.a.w(this.mContext, c.c.action_bar_color);
    this.PVa = af.mU(getContext()).inflate(c.g.webview_action_bar, this, false);
    setActionBarViewColor(this.WHg);
    this.WGV.addView(this.PVa, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.WGW = ((RelativeLayout)this.PVa.findViewById(c.f.action_bar_root));
    this.WGX = this.PVa.findViewById(c.f.margin_view);
    this.WGY = ((ImageView)this.PVa.findViewById(c.f.divider));
    this.ugB = ((ImageView)this.PVa.findViewById(c.f.actionbar_back));
    this.ugB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (!n.this.iue()) {
          n.this.fEH();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78375);
      }
    });
    this.sUt = ((TextView)this.PVa.findViewById(c.f.title));
    com.tencent.mm.ui.a.v(this.sUt, c.d.BodyTextSize);
    this.WGZ = ((LinearLayout)this.PVa.findViewById(c.f.actionbar_option_layout));
    this.ImI = ((ImageView)this.PVa.findViewById(c.f.actionbar_option_btn));
    this.ImI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        n.this.cxQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78376);
      }
    });
    this.ImI.setClickable(false);
    this.WHa = ((TextView)this.PVa.findViewById(c.f.actionbar_option_text));
    this.WHa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        n.this.cxQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78377);
      }
    });
    this.WHa.setClickable(false);
    AppMethodBeat.o(78384);
  }
  
  private boolean IH(boolean paramBoolean)
  {
    switch (this.WHj)
    {
    default: 
      return paramBoolean;
    case 0: 
      return true;
    }
    return false;
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(78391);
    int i = bf.fs(MMApplicationContext.getContext());
    AppMethodBeat.o(78391);
    return i;
  }
  
  private void setActionBarColor(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(78399);
    Log.i("MicroMsg.GameWebViewActionBar", "setActionBarColor, color : %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt;
    if (paramInt == 0) {
      i = getResources().getColor(c.c.white);
    }
    boolean bool2 = IH(bb.aAF(i));
    com.tencent.mm.ui.statusbar.b localb = this.WGV;
    if (!bool2) {}
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.h(localb, i, bool1);
      this.WHl = Integer.valueOf(i);
      this.WHm = bool2;
      setActionBarViewColor(i);
      wm(bool2);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
  }
  
  private void setActionBarViewColor(int paramInt)
  {
    AppMethodBeat.i(295964);
    if (this.PVa != null)
    {
      this.PVa.setBackgroundColor(paramInt);
      if ((paramInt >> 24 & 0xFF) / 255.0F > 0.0F)
      {
        this.PVa.setClickable(true);
        AppMethodBeat.o(295964);
        return;
      }
      this.PVa.setClickable(false);
    }
    AppMethodBeat.o(295964);
  }
  
  private void setImmersiveStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(295962);
    Log.i("MicroMsg.GameWebViewActionBar", "setImmersiveStyle");
    boolean bool = IH(paramBoolean);
    com.tencent.mm.ui.statusbar.b localb = this.WGV;
    if (!bool) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.mm.ui.statusbar.a.h(localb, 0, paramBoolean);
      this.WHl = Integer.valueOf(0);
      this.WHm = bool;
      setActionBarViewColor(0);
      this.sUt.setVisibility(8);
      this.WGY.setVisibility(8);
      this.ugB.setImageAlpha(255);
      this.ImI.setImageAlpha(255);
      wm(bool);
      AppMethodBeat.o(295962);
      return;
    }
  }
  
  final void IG(boolean paramBoolean)
  {
    AppMethodBeat.i(296005);
    if (this.ImI != null)
    {
      if (paramBoolean)
      {
        this.ImI.setVisibility(8);
        AppMethodBeat.o(296005);
        return;
      }
      this.ImI.setVisibility(0);
    }
    AppMethodBeat.o(296005);
  }
  
  public final void aa(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78395);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().bkf(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78395);
  }
  
  public final void ab(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78396);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().bkg(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void cxQ()
  {
    AppMethodBeat.i(78389);
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).hideVKBHavingResult();
    }
    Runnable local5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78378);
        n.a(n.this, new p(n.a(n.this), n.this.getMenuHelp()));
        AppMethodBeat.o(78378);
      }
    };
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      MMHandlerThread.postToMainThreadDelayed(local5, l);
      AppMethodBeat.o(78389);
      return;
    }
  }
  
  public void fEH()
  {
    AppMethodBeat.i(78392);
    this.WFG.iR(true);
    AppMethodBeat.o(78392);
  }
  
  public void fEI()
  {
    AppMethodBeat.i(78390);
    if (this.WHb != null) {
      this.WHb.iuH();
    }
    AppMethodBeat.o(78390);
  }
  
  protected com.tencent.mm.plugin.webview.luggage.b.n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.WHc == null) {
      this.WHc = new com.tencent.mm.plugin.webview.luggage.b.n();
    }
    com.tencent.mm.plugin.webview.luggage.b.n localn = this.WHc;
    AppMethodBeat.o(78388);
    return localn;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int getTopBarHeight()
  {
    AppMethodBeat.i(295990);
    int i = this.WGV.getHeight();
    AppMethodBeat.o(295990);
    return i;
  }
  
  public final void iuD()
  {
    AppMethodBeat.i(295988);
    this.WHk = true;
    if (this.WGY != null) {
      this.WGY.setVisibility(8);
    }
    if (this.WGX != null) {
      this.WGX.setVisibility(8);
    }
    AppMethodBeat.o(295988);
  }
  
  public final void iuE()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().iuE();
    AppMethodBeat.o(78393);
  }
  
  public final void iuF()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().iuF();
    AppMethodBeat.o(78394);
  }
  
  public final void iuG()
  {
    AppMethodBeat.i(296006);
    setImmersiveStyle(this.WHi);
    AppMethodBeat.o(296006);
  }
  
  public final boolean iue()
  {
    AppMethodBeat.i(78398);
    if ((this.WHd != null) && (this.WHd.iuN()))
    {
      Object localObject1 = this.WHd.iuO();
      String str1 = this.WHd.iuP();
      String str2 = this.WHd.iuQ();
      Log.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
      View localView = View.inflate(getContext(), c.g.mm_alert_checkbox, null);
      Object localObject2 = (CheckBox)localView.findViewById(c.f.mm_alert_dialog_cb);
      ((CheckBox)localObject2).setChecked(false);
      ((CheckBox)localObject2).setVisibility(8);
      localObject2 = (TextView)localView.findViewById(c.f.mm_alert_dialog_info);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(c.c.normal_text_color));
      localObject1 = (TextView)localView.findViewById(c.f.mm_alert_dialog_cb_txt);
      ((TextView)localObject1).setTextColor(getResources().getColor(c.c.normal_text_color));
      ((TextView)localObject1).setVisibility(8);
      this.WHe = k.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          n.b(n.this);
          n.this.fEH();
          AppMethodBeat.o(78379);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78380);
          n.b(n.this);
          AppMethodBeat.o(78380);
        }
      });
      AppMethodBeat.o(78398);
      return true;
    }
    AppMethodBeat.o(78398);
    return false;
  }
  
  public void onDestroy() {}
  
  public void onForeground() {}
  
  public final void s(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(296002);
    this.WHg = paramInt;
    this.WHh = paramBoolean1;
    this.WHi = paramBoolean2;
    if ((this.WHh) && ((this.WHl == null) || (this.WHl.intValue() == 0)))
    {
      setImmersiveStyle(paramBoolean2);
      AppMethodBeat.o(296002);
      return;
    }
    setActionBarColor(paramInt);
    AppMethodBeat.o(296002);
  }
  
  public void setActionBarColorValue(int paramInt)
  {
    this.WHg = paramInt;
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(296009);
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      AppMethodBeat.o(296009);
      return;
    }
    if (paramFloat == 0.0F)
    {
      iuG();
      AppMethodBeat.o(296009);
      return;
    }
    int i = (int)(255.0F * paramFloat);
    this.sUt.setVisibility(0);
    if (this.WHk) {
      this.WGY.setVisibility(8);
    }
    for (;;)
    {
      setActionBarColor((this.WHg >> 16 & 0xFF) << 16 | i << 24 | (this.WHg >> 8 & 0xFF) << 8 | this.WHg & 0xFF);
      this.sUt.setAlpha(paramFloat);
      this.WGY.setImageAlpha(i);
      this.ugB.setImageAlpha(i);
      this.ImI.setImageAlpha(i);
      AppMethodBeat.o(296009);
      return;
      this.WGY.setVisibility(0);
    }
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.KIE = paramInt;
    this.ugB.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new y(paramBundle))
    {
      this.WHd = paramBundle;
      AppMethodBeat.o(78397);
      return;
    }
  }
  
  public void setIconDark(int paramInt)
  {
    this.WHj = paramInt;
  }
  
  public void setNavigationBarButtons(final Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(78400);
    if (paramBundle == null)
    {
      AppMethodBeat.o(78400);
      return;
    }
    String str3 = paramBundle.getString("set_navigation_bar_buttons_left_text_color");
    final boolean bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
    final String str1 = paramBundle.getString("set_navigation_bar_buttons_text");
    String str2 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
    String str4 = paramBundle.getString("set_navigation_bar_buttons_text_color");
    final boolean bool2 = paramBundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
    f.fo(str3, -16777216);
    final int i = (int)f.blC(str4);
    paramBundle = localObject;
    if (!Util.isNullOrNil(str2)) {}
    try
    {
      paramBundle = f.blD(str2);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295974);
          if ((n.this == null) || (n.a(n.this) == null))
          {
            AppMethodBeat.o(295974);
            return;
          }
          if (bool1)
          {
            n.a(n.this, true);
            AppMethodBeat.o(295974);
            return;
          }
          n.a(n.this, false);
          if ((n.d(n.this) == null) || (n.e(n.this) == null))
          {
            AppMethodBeat.o(295974);
            return;
          }
          n.b(n.this, false);
          if ((paramBundle != null) && (!paramBundle.isRecycled()))
          {
            n.d(n.this).setVisibility(0);
            n.d(n.this).setImageBitmap(paramBundle);
            n.e(n.this).setVisibility(8);
            n.b(n.this, true);
          }
          for (;;)
          {
            if (bool2)
            {
              n.d(n.this).setOnClickListener(n.f(n.this));
              n.e(n.this).setOnClickListener(n.f(n.this));
            }
            AppMethodBeat.o(295974);
            return;
            if (!Util.isNullOrNil(str1))
            {
              n.d(n.this).setVisibility(8);
              n.e(n.this).setVisibility(0);
              n.e(n.this).setText(str1);
              if (i != -1) {
                n.e(n.this).setTextColor(i);
              }
            }
          }
        }
      });
      AppMethodBeat.o(78400);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { paramBundle });
        paramBundle = localObject;
      }
    }
  }
  
  public void setOptionEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(78385);
    if (paramBoolean)
    {
      this.ImI.setClickable(true);
      this.WHa.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.ImI.setClickable(false);
    this.WHa.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.sUt.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    Log.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.sUt.setText(paramString);
    AppMethodBeat.o(78386);
  }
  
  protected void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(296001);
    if (!paramBoolean)
    {
      this.sUt.setTextColor(-16777216);
      this.ugB.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78381);
          n.c(n.this).setColorFilter(-16777216);
          AppMethodBeat.o(78381);
        }
      }, 100L);
      if (!this.WHf)
      {
        this.ImI.setImageResource(c.h.actionbar_icon_dark_more);
        AppMethodBeat.o(296001);
      }
    }
    else
    {
      this.sUt.setTextColor(-1);
      this.ugB.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(295866);
          n.c(n.this).setColorFilter(-1);
          AppMethodBeat.o(295866);
        }
      }, 100L);
      if (!this.WHf) {
        this.ImI.setImageResource(c.h.actionbar_icon_light_more);
      }
    }
    AppMethodBeat.o(296001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n
 * JD-Core Version:    0.7.0.1
 */