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
import android.widget.TextView;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
  extends FrameLayout
{
  private ImageView CvS;
  private int EOf;
  private View JDY;
  private g PPn;
  private View PQA;
  private ImageView PQB;
  protected LinearLayout PQC;
  private TextView PQD;
  private o PQE;
  protected n PQF;
  private x PQG;
  public com.tencent.mm.ui.widget.a.d PQH;
  private boolean PQI;
  private int PQJ;
  private boolean PQK;
  private boolean PQL;
  int PQM;
  private boolean PQN;
  public Integer PQO;
  public boolean PQP;
  private View.OnClickListener PQQ;
  public com.tencent.mm.ui.statusbar.b PQz;
  protected Context mContext;
  private String mTitle;
  private TextView pPT;
  private ImageView raL;
  
  public m(g paramg)
  {
    super(paramg.mContext);
    AppMethodBeat.i(78384);
    this.PQH = null;
    this.PQI = false;
    this.PQM = -1;
    this.EOf = c.h.actionbar_quit_webview_icon;
    this.PQN = false;
    this.PQQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(214560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (m.a(m.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214560);
          return;
        }
        m.a(m.this).crX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject NU()
          {
            AppMethodBeat.i(223930);
            JSONObject localJSONObject = new JSONObject();
            AppMethodBeat.o(223930);
            return localJSONObject;
          }
          
          public final String name()
          {
            return "onNavigationBarRightButtonClick";
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(214560);
      }
    };
    setId(c.f.luggage_action_bar);
    this.mContext = paramg.mContext;
    this.PPn = paramg;
    setBackgroundColor(0);
    this.PQz = new c(this.mContext);
    addView(this.PQz, -1, -1);
    this.PQJ = androidx.core.content.a.w(this.mContext, c.c.action_bar_color);
    this.JDY = ad.kS(getContext()).inflate(c.g.webview_action_bar, this, false);
    setActionBarViewColor(this.PQJ);
    this.PQz.addView(this.JDY, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.PQA = this.JDY.findViewById(c.f.margin_view);
    this.PQB = ((ImageView)this.JDY.findViewById(c.f.divider));
    this.raL = ((ImageView)this.JDY.findViewById(c.f.actionbar_back));
    this.raL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!m.this.gUw()) {
          m.this.ewP();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78375);
      }
    });
    this.pPT = ((TextView)this.JDY.findViewById(c.f.title));
    this.PQC = ((LinearLayout)this.JDY.findViewById(c.f.actionbar_option_layout));
    this.CvS = ((ImageView)this.JDY.findViewById(c.f.actionbar_option_btn));
    this.CvS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        m.this.bXF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78376);
      }
    });
    this.CvS.setClickable(false);
    this.PQD = ((TextView)this.JDY.findViewById(c.f.actionbar_option_text));
    this.PQD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        m.this.bXF();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78377);
      }
    });
    this.PQD.setClickable(false);
    if (com.tencent.mm.ci.a.ko(getContext())) {
      this.pPT.setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), c.d.BodyTextSize) * com.tencent.mm.ci.a.km(getContext()));
    }
    AppMethodBeat.o(78384);
  }
  
  private boolean CZ(boolean paramBoolean)
  {
    switch (this.PQM)
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
    int i = ax.ew(MMApplicationContext.getContext());
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
    boolean bool2 = CZ(au.auk(i));
    com.tencent.mm.ui.statusbar.b localb = this.PQz;
    if (!bool2) {}
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.f(localb, i, bool1);
      this.PQO = Integer.valueOf(i);
      this.PQP = bool2;
      setActionBarViewColor(i);
      sh(bool2);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
  }
  
  private void setActionBarViewColor(int paramInt)
  {
    AppMethodBeat.i(256979);
    if (this.JDY != null)
    {
      this.JDY.setBackgroundColor(paramInt);
      if ((paramInt >> 24 & 0xFF) / 255.0F > 0.0F)
      {
        this.JDY.setClickable(true);
        AppMethodBeat.o(256979);
        return;
      }
      this.JDY.setClickable(false);
    }
    AppMethodBeat.o(256979);
  }
  
  private void setImmersiveStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(256978);
    Log.i("MicroMsg.GameWebViewActionBar", "setImmersiveStyle");
    boolean bool = CZ(paramBoolean);
    com.tencent.mm.ui.statusbar.b localb = this.PQz;
    if (!bool) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.mm.ui.statusbar.a.f(localb, 0, paramBoolean);
      this.PQO = Integer.valueOf(0);
      this.PQP = bool;
      setActionBarViewColor(0);
      this.pPT.setVisibility(8);
      this.PQB.setVisibility(8);
      this.raL.setImageAlpha(255);
      this.CvS.setImageAlpha(255);
      sh(bool);
      AppMethodBeat.o(256978);
      return;
    }
  }
  
  final void CY(boolean paramBoolean)
  {
    AppMethodBeat.i(256971);
    if (this.CvS != null)
    {
      if (paramBoolean)
      {
        this.CvS.setVisibility(8);
        AppMethodBeat.o(256971);
        return;
      }
      this.CvS.setVisibility(0);
    }
    AppMethodBeat.o(256971);
  }
  
  public final void V(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78395);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().bku(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78395);
  }
  
  public final void W(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78396);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().bkv(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void bXF()
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
        m.a(m.this, new o(m.a(m.this), m.this.getMenuHelp()));
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
  
  public void ewP()
  {
    AppMethodBeat.i(78392);
    this.PPn.hS(true);
    AppMethodBeat.o(78392);
  }
  
  public void ewQ()
  {
    AppMethodBeat.i(78390);
    if (this.PQE != null) {
      this.PQE.gUW();
    }
    AppMethodBeat.o(78390);
  }
  
  public final void gUS()
  {
    AppMethodBeat.i(256948);
    this.PQN = true;
    if (this.PQB != null) {
      this.PQB.setVisibility(8);
    }
    if (this.PQA != null) {
      this.PQA.setVisibility(8);
    }
    AppMethodBeat.o(256948);
  }
  
  public final void gUT()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().gUT();
    AppMethodBeat.o(78393);
  }
  
  public final void gUU()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().gUU();
    AppMethodBeat.o(78394);
  }
  
  public final void gUV()
  {
    AppMethodBeat.i(256982);
    setImmersiveStyle(this.PQL);
    AppMethodBeat.o(256982);
  }
  
  public final boolean gUw()
  {
    AppMethodBeat.i(78398);
    if ((this.PQG != null) && (this.PQG.gVc()))
    {
      Object localObject1 = this.PQG.gVd();
      String str1 = this.PQG.gVe();
      String str2 = this.PQG.gVf();
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
      this.PQH = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          m.b(m.this);
          m.this.ewP();
          AppMethodBeat.o(78379);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78380);
          m.b(m.this);
          AppMethodBeat.o(78380);
        }
      });
      AppMethodBeat.o(78398);
      return true;
    }
    AppMethodBeat.o(78398);
    return false;
  }
  
  protected n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.PQF == null) {
      this.PQF = new n();
    }
    n localn = this.PQF;
    AppMethodBeat.o(78388);
    return localn;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int getTopBarHeight()
  {
    AppMethodBeat.i(256949);
    int i = this.PQz.getHeight();
    AppMethodBeat.o(256949);
    return i;
  }
  
  public final void n(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(256965);
    this.PQJ = paramInt;
    this.PQK = paramBoolean1;
    this.PQL = paramBoolean2;
    if ((this.PQK) && ((this.PQO == null) || (this.PQO.intValue() == 0)))
    {
      setImmersiveStyle(paramBoolean2);
      AppMethodBeat.o(256965);
      return;
    }
    setActionBarColor(paramInt);
    AppMethodBeat.o(256965);
  }
  
  public void onDestroy() {}
  
  public void onForeground() {}
  
  public void setActionBarColorValue(int paramInt)
  {
    this.PQJ = paramInt;
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(256986);
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      AppMethodBeat.o(256986);
      return;
    }
    if (paramFloat == 0.0F)
    {
      gUV();
      AppMethodBeat.o(256986);
      return;
    }
    int i = (int)(255.0F * paramFloat);
    this.pPT.setVisibility(0);
    if (this.PQN) {
      this.PQB.setVisibility(8);
    }
    for (;;)
    {
      setActionBarColor((this.PQJ >> 16 & 0xFF) << 16 | i << 24 | (this.PQJ >> 8 & 0xFF) << 8 | this.PQJ & 0xFF);
      this.pPT.setAlpha(paramFloat);
      this.PQB.setImageAlpha(i);
      this.raL.setImageAlpha(i);
      this.CvS.setImageAlpha(i);
      AppMethodBeat.o(256986);
      return;
      this.PQB.setVisibility(0);
    }
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.EOf = paramInt;
    this.raL.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new x(paramBundle))
    {
      this.PQG = paramBundle;
      AppMethodBeat.o(78397);
      return;
    }
  }
  
  public void setIconDark(int paramInt)
  {
    this.PQM = paramInt;
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
    e.he(str3, -16777216);
    final int i = (int)e.bmb(str4);
    paramBundle = localObject;
    if (!Util.isNullOrNil(str2)) {}
    try
    {
      paramBundle = e.bmc(str2);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215668);
          if ((m.this == null) || (m.a(m.this) == null))
          {
            AppMethodBeat.o(215668);
            return;
          }
          if (bool1)
          {
            m.a(m.this, true);
            AppMethodBeat.o(215668);
            return;
          }
          m.a(m.this, false);
          if ((m.d(m.this) == null) || (m.e(m.this) == null))
          {
            AppMethodBeat.o(215668);
            return;
          }
          m.b(m.this, false);
          if ((paramBundle != null) && (!paramBundle.isRecycled()))
          {
            m.d(m.this).setVisibility(0);
            m.d(m.this).setImageBitmap(paramBundle);
            m.e(m.this).setVisibility(8);
            m.b(m.this, true);
          }
          for (;;)
          {
            if (bool2)
            {
              m.d(m.this).setOnClickListener(m.f(m.this));
              m.e(m.this).setOnClickListener(m.f(m.this));
            }
            AppMethodBeat.o(215668);
            return;
            if (!Util.isNullOrNil(str1))
            {
              m.d(m.this).setVisibility(8);
              m.e(m.this).setVisibility(0);
              m.e(m.this).setText(str1);
              if (i != -1) {
                m.e(m.this).setTextColor(i);
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
      this.CvS.setClickable(true);
      this.PQD.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.CvS.setClickable(false);
    this.PQD.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.pPT.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    Log.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.pPT.setText(paramString);
    AppMethodBeat.o(78386);
  }
  
  protected void sh(boolean paramBoolean)
  {
    AppMethodBeat.i(256962);
    if (!paramBoolean)
    {
      this.pPT.setTextColor(-16777216);
      this.raL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78381);
          m.c(m.this).setColorFilter(-16777216);
          AppMethodBeat.o(78381);
        }
      }, 100L);
      if (!this.PQI)
      {
        this.CvS.setImageResource(c.h.actionbar_icon_dark_more);
        AppMethodBeat.o(256962);
      }
    }
    else
    {
      this.pPT.setTextColor(-1);
      this.raL.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(266080);
          m.c(m.this).setColorFilter(-1);
          AppMethodBeat.o(266080);
        }
      }, 100L);
      if (!this.PQI) {
        this.CvS.setImageResource(c.h.actionbar_icon_light_more);
      }
    }
    AppMethodBeat.o(256962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */