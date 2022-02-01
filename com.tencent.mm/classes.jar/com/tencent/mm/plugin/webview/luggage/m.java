package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
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
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.z;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
  extends FrameLayout
{
  private g DOl;
  private TextView DPA;
  private o DPB;
  protected n DPC;
  private v DPD;
  public com.tencent.mm.ui.widget.a.d DPE;
  private boolean DPF;
  private int DPG;
  private boolean DPH;
  private boolean DPI;
  private boolean DPJ;
  private View.OnClickListener DPK;
  private com.tencent.mm.ui.statusbar.b DPv;
  private View DPw;
  private ImageView DPx;
  protected LinearLayout DPy;
  private ImageView DPz;
  private TextView lCL;
  protected Context mContext;
  private ImageView mGO;
  private String mTitle;
  private int vBn;
  private View yXP;
  
  public m(g paramg)
  {
    super(paramg.mContext);
    AppMethodBeat.i(78384);
    this.DPE = null;
    this.DPF = false;
    this.vBn = 2131689508;
    this.DPJ = false;
    this.DPK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207888);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (m.a(m.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207888);
          return;
        }
        m.a(m.this).chX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BO()
          {
            AppMethodBeat.i(207887);
            JSONObject localJSONObject = new JSONObject();
            AppMethodBeat.o(207887);
            return localJSONObject;
          }
          
          public final String name()
          {
            return "onNavigationBarRightButtonClick";
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207888);
      }
    };
    setId(2131308150);
    this.mContext = paramg.mContext;
    this.DOl = paramg;
    setBackgroundColor(0);
    this.DPv = new c(this.mContext);
    addView(this.DPv, -1, -1);
    this.DPG = android.support.v4.content.b.n(this.mContext, 2131099873);
    this.yXP = z.jO(getContext()).inflate(2131496079, this, false);
    this.yXP.setBackgroundColor(this.DPG);
    this.DPv.addView(this.yXP, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.DPw = this.yXP.findViewById(2131308352);
    this.DPx = ((ImageView)this.yXP.findViewById(2131299154));
    this.mGO = ((ImageView)this.yXP.findViewById(2131296396));
    this.mGO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!m.this.ePd()) {
          m.this.cXo();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78375);
      }
    });
    this.lCL = ((TextView)this.yXP.findViewById(2131305902));
    this.DPy = ((LinearLayout)this.yXP.findViewById(2131296410));
    this.DPz = ((ImageView)this.yXP.findViewById(2131296409));
    this.DPz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        m.this.cXp();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78376);
      }
    });
    this.DPz.setClickable(false);
    this.DPA = ((TextView)this.yXP.findViewById(2131296411));
    this.DPA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        m.this.cXp();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78377);
      }
    });
    this.DPA.setClickable(false);
    AppMethodBeat.o(78384);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(78391);
    int i = ar.dT(aj.getContext());
    AppMethodBeat.o(78391);
    return i;
  }
  
  private void setImmersiveStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(207893);
    ad.i("MicroMsg.GameWebViewActionBar", "setImmersiveStyle");
    com.tencent.mm.ui.statusbar.b localb = this.DPv;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.statusbar.a.e(localb, 0, bool);
      this.yXP.setBackgroundColor(0);
      this.lCL.setVisibility(8);
      this.DPx.setVisibility(8);
      this.mGO.setImageAlpha(255);
      this.DPz.setImageAlpha(255);
      if (!paramBoolean) {
        break;
      }
      this.mGO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207885);
          m.c(m.this).setColorFilter(-1);
          AppMethodBeat.o(207885);
        }
      });
      if (this.DPF) {
        break label156;
      }
      this.DPz.setImageResource(2131689500);
      AppMethodBeat.o(207893);
      return;
    }
    this.mGO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207886);
        m.c(m.this).setColorFilter(-16777216);
        AppMethodBeat.o(207886);
      }
    });
    if (!this.DPF) {
      this.DPz.setImageResource(2131689493);
    }
    label156:
    AppMethodBeat.o(207893);
  }
  
  public final void N(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78395);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().aHf(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78395);
  }
  
  public final void O(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78396);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().aHg(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void cXo()
  {
    AppMethodBeat.i(78392);
    this.DOl.gg(true);
    AppMethodBeat.o(78392);
  }
  
  public void cXp()
  {
    AppMethodBeat.i(78389);
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).hideVKBHavingResult();
    }
    Runnable local7 = new Runnable()
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
      aq.o(local7, l);
      AppMethodBeat.o(78389);
      return;
    }
  }
  
  public void cXq()
  {
    AppMethodBeat.i(78390);
    if (this.DPB != null) {
      this.DPB.ePB();
    }
    AppMethodBeat.o(78390);
  }
  
  public final void ePA()
  {
    AppMethodBeat.i(207894);
    setImmersiveStyle(this.DPI);
    AppMethodBeat.o(207894);
  }
  
  public final boolean ePd()
  {
    AppMethodBeat.i(78398);
    if ((this.DPD != null) && (this.DPD.ePK()))
    {
      Object localObject1 = this.DPD.ePL();
      String str1 = this.DPD.ePM();
      String str2 = this.DPD.ePN();
      ad.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
      View localView = View.inflate(getContext(), 2131494763, null);
      Object localObject2 = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject2).setChecked(false);
      ((CheckBox)localObject2).setVisibility(8);
      localObject2 = (TextView)localView.findViewById(2131302306);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131100711));
      localObject1 = (TextView)localView.findViewById(2131302305);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131100711));
      ((TextView)localObject1).setVisibility(8);
      this.DPE = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          m.b(m.this);
          m.this.cXo();
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
  
  public final void ePx()
  {
    AppMethodBeat.i(207891);
    this.DPJ = true;
    if (this.DPx != null) {
      this.DPx.setVisibility(8);
    }
    if (this.DPw != null) {
      this.DPw.setVisibility(8);
    }
    AppMethodBeat.o(207891);
  }
  
  public final void ePy()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().ePy();
    AppMethodBeat.o(78393);
  }
  
  public final void ePz()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().ePz();
    AppMethodBeat.o(78394);
  }
  
  protected n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.DPC == null) {
      this.DPC = new n();
    }
    n localn = this.DPC;
    AppMethodBeat.o(78388);
    return localn;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public final void i(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(207892);
    this.DPG = paramInt;
    this.DPH = paramBoolean1;
    this.DPI = paramBoolean2;
    if (this.DPH)
    {
      setImmersiveStyle(paramBoolean2);
      AppMethodBeat.o(207892);
      return;
    }
    setActionBarColor(paramInt);
    AppMethodBeat.o(207892);
  }
  
  public void onDestroy() {}
  
  public void onForeground() {}
  
  public void setActionBarColor(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(78399);
    ad.i("MicroMsg.GameWebViewActionBar", "setActionBarColor, color : %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt;
    if (paramInt == 0) {
      i = getResources().getColor(2131101179);
    }
    boolean bool2 = ao.abX(i);
    com.tencent.mm.ui.statusbar.b localb = this.DPv;
    if (!bool2) {}
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.e(localb, i, bool1);
      this.yXP.setBackgroundColor(i);
      if (bool2) {
        break;
      }
      this.lCL.setTextColor(-16777216);
      this.mGO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78381);
          m.c(m.this).setColorFilter(-16777216);
          AppMethodBeat.o(78381);
        }
      });
      if (this.DPF) {
        break label177;
      }
      this.DPz.setImageResource(2131689493);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
    this.lCL.setTextColor(-1);
    this.mGO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207889);
        m.c(m.this).setColorFilter(-1);
        AppMethodBeat.o(207889);
      }
    });
    if (!this.DPF) {
      this.DPz.setImageResource(2131689500);
    }
    label177:
    AppMethodBeat.o(78399);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(207895);
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      AppMethodBeat.o(207895);
      return;
    }
    if (paramFloat == 0.0F)
    {
      ePA();
      AppMethodBeat.o(207895);
      return;
    }
    int i = (int)(255.0F * paramFloat);
    this.lCL.setVisibility(0);
    if (this.DPJ) {
      this.DPx.setVisibility(8);
    }
    for (;;)
    {
      setActionBarColor((this.DPG >> 16 & 0xFF) << 16 | i << 24 | (this.DPG >> 8 & 0xFF) << 8 | this.DPG & 0xFF);
      this.lCL.setAlpha(paramFloat);
      this.DPx.setImageAlpha(i);
      this.mGO.setImageAlpha(i);
      this.DPz.setImageAlpha(i);
      AppMethodBeat.o(207895);
      return;
      this.DPx.setVisibility(0);
    }
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.vBn = paramInt;
    this.mGO.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new v(paramBundle))
    {
      this.DPD = paramBundle;
      AppMethodBeat.o(78397);
      return;
    }
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
    final int i = e.fO(str3, -16777216);
    final int j = (int)e.aIG(str4);
    paramBundle = localObject;
    if (!bt.isNullOrNil(str2)) {}
    try
    {
      paramBundle = e.aIH(str2);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207890);
          if ((m.this == null) || (m.a(m.this) == null))
          {
            AppMethodBeat.o(207890);
            return;
          }
          if (bool1) {
            m.a(m.this, true);
          }
          label322:
          for (;;)
          {
            Drawable localDrawable = m.this.getResources().getDrawable(m.g(m.this)).mutate();
            localDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            if (m.c(m.this) != null) {
              m.c(m.this).setImageDrawable(localDrawable);
            }
            AppMethodBeat.o(207890);
            return;
            m.a(m.this, false);
            if ((m.d(m.this) == null) || (m.e(m.this) == null))
            {
              AppMethodBeat.o(207890);
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
              if (!bool2) {
                break label322;
              }
              m.d(m.this).setOnClickListener(m.f(m.this));
              m.e(m.this).setOnClickListener(m.f(m.this));
              break;
              if (!bt.isNullOrNil(str1))
              {
                m.d(m.this).setVisibility(8);
                m.e(m.this).setVisibility(0);
                m.e(m.this).setText(str1);
                if (j != -1) {
                  m.e(m.this).setTextColor(j);
                }
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
        ad.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { paramBundle });
        paramBundle = localObject;
      }
    }
  }
  
  public void setOptionEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(78385);
    if (paramBoolean)
    {
      this.DPz.setClickable(true);
      this.DPA.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.DPz.setClickable(false);
    this.DPA.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.lCL.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    ad.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.lCL.setText(paramString);
    AppMethodBeat.o(78386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */