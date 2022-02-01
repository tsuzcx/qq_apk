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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.z;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
  extends FrameLayout
{
  private g Egl;
  private TextView EhA;
  private o EhB;
  protected n EhC;
  private v EhD;
  public com.tencent.mm.ui.widget.a.d EhE;
  private boolean EhF;
  private int EhG;
  private boolean EhH;
  private boolean EhI;
  private boolean EhJ;
  private View.OnClickListener EhK;
  private com.tencent.mm.ui.statusbar.b Ehv;
  private View Ehw;
  private ImageView Ehx;
  protected LinearLayout Ehy;
  private ImageView Ehz;
  private TextView lHk;
  protected Context mContext;
  private ImageView mLS;
  private String mTitle;
  private int vNr;
  private View zoq;
  
  public m(g paramg)
  {
    super(paramg.mContext);
    AppMethodBeat.i(78384);
    this.EhE = null;
    this.EhF = false;
    this.vNr = 2131689508;
    this.EhJ = false;
    this.EhK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198068);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (m.a(m.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198068);
          return;
        }
        m.a(m.this).chX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BP()
          {
            AppMethodBeat.i(198067);
            JSONObject localJSONObject = new JSONObject();
            AppMethodBeat.o(198067);
            return localJSONObject;
          }
          
          public final String name()
          {
            return "onNavigationBarRightButtonClick";
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198068);
      }
    };
    setId(2131308150);
    this.mContext = paramg.mContext;
    this.Egl = paramg;
    setBackgroundColor(0);
    this.Ehv = new c(this.mContext);
    addView(this.Ehv, -1, -1);
    this.EhG = android.support.v4.content.b.n(this.mContext, 2131099873);
    this.zoq = z.jV(getContext()).inflate(2131496079, this, false);
    this.zoq.setBackgroundColor(this.EhG);
    this.Ehv.addView(this.zoq, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.Ehw = this.zoq.findViewById(2131308352);
    this.Ehx = ((ImageView)this.zoq.findViewById(2131299154));
    this.mLS = ((ImageView)this.zoq.findViewById(2131296396));
    this.mLS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!m.this.eSP()) {
          m.this.cZY();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78375);
      }
    });
    this.lHk = ((TextView)this.zoq.findViewById(2131305902));
    this.Ehy = ((LinearLayout)this.zoq.findViewById(2131296410));
    this.Ehz = ((ImageView)this.zoq.findViewById(2131296409));
    this.Ehz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        m.this.cZZ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78376);
      }
    });
    this.Ehz.setClickable(false);
    this.EhA = ((TextView)this.zoq.findViewById(2131296411));
    this.EhA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        m.this.cZZ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78377);
      }
    });
    this.EhA.setClickable(false);
    if (com.tencent.mm.cb.a.ir(getContext())) {
      this.lHk.setTextSize(0, com.tencent.mm.cb.a.ay(getContext(), 2131165200) * com.tencent.mm.cb.a.ip(getContext()));
    }
    AppMethodBeat.o(78384);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(78391);
    int i = com.tencent.mm.ui.ar.dX(ak.getContext());
    AppMethodBeat.o(78391);
    return i;
  }
  
  public final void O(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78395);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().aIz(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78395);
  }
  
  public final void P(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78396);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().aIA(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void cZY()
  {
    AppMethodBeat.i(78392);
    this.Egl.ge(true);
    AppMethodBeat.o(78392);
  }
  
  public void cZZ()
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
      com.tencent.mm.sdk.platformtools.ar.o(local7, l);
      AppMethodBeat.o(78389);
      return;
    }
  }
  
  public void daa()
  {
    AppMethodBeat.i(78390);
    if (this.EhB != null) {
      this.EhB.eTn();
    }
    AppMethodBeat.o(78390);
  }
  
  public final boolean eSP()
  {
    AppMethodBeat.i(78398);
    if ((this.EhD != null) && (this.EhD.eTw()))
    {
      Object localObject1 = this.EhD.eTx();
      String str1 = this.EhD.eTy();
      String str2 = this.EhD.eTz();
      ae.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
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
      this.EhE = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          m.b(m.this);
          m.this.cZY();
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
  
  public final void eTj()
  {
    AppMethodBeat.i(198071);
    this.EhJ = true;
    if (this.Ehx != null) {
      this.Ehx.setVisibility(8);
    }
    if (this.Ehw != null) {
      this.Ehw.setVisibility(8);
    }
    AppMethodBeat.o(198071);
  }
  
  public final void eTk()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().eTk();
    AppMethodBeat.o(78393);
  }
  
  public final void eTl()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().eTl();
    AppMethodBeat.o(78394);
  }
  
  public final void eTm()
  {
    AppMethodBeat.i(198074);
    setImmersiveStyle(this.EhI);
    AppMethodBeat.o(198074);
  }
  
  protected n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.EhC == null) {
      this.EhC = new n();
    }
    n localn = this.EhC;
    AppMethodBeat.o(78388);
    return localn;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public final void i(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(198072);
    this.EhG = paramInt;
    this.EhH = paramBoolean1;
    this.EhI = paramBoolean2;
    if (this.EhH)
    {
      setImmersiveStyle(paramBoolean2);
      AppMethodBeat.o(198072);
      return;
    }
    setActionBarColor(paramInt);
    AppMethodBeat.o(198072);
  }
  
  public void onDestroy() {}
  
  public void onForeground() {}
  
  protected void setActionBarColor(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(78399);
    ae.i("MicroMsg.GameWebViewActionBar", "setActionBarColor, color : %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt;
    if (paramInt == 0) {
      i = getResources().getColor(2131101179);
    }
    boolean bool2 = ao.acF(i);
    com.tencent.mm.ui.statusbar.b localb = this.Ehv;
    if (!bool2) {}
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.e(localb, i, bool1);
      this.zoq.setBackgroundColor(i);
      if (bool2) {
        break;
      }
      this.lHk.setTextColor(-16777216);
      this.mLS.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78381);
          m.c(m.this).setColorFilter(-16777216);
          AppMethodBeat.o(78381);
        }
      });
      if (this.EhF) {
        break label178;
      }
      this.Ehz.setImageResource(2131689493);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
    this.lHk.setTextColor(-1);
    this.mLS.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198069);
        m.c(m.this).setColorFilter(-1);
        AppMethodBeat.o(198069);
      }
    });
    if (!this.EhF) {
      this.Ehz.setImageResource(2131689500);
    }
    label178:
    AppMethodBeat.o(78399);
  }
  
  public void setActionBarColorValue(int paramInt)
  {
    this.EhG = paramInt;
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(198075);
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      AppMethodBeat.o(198075);
      return;
    }
    if (paramFloat == 0.0F)
    {
      eTm();
      AppMethodBeat.o(198075);
      return;
    }
    int i = (int)(255.0F * paramFloat);
    this.lHk.setVisibility(0);
    if (this.EhJ) {
      this.Ehx.setVisibility(8);
    }
    for (;;)
    {
      setActionBarColor((this.EhG >> 16 & 0xFF) << 16 | i << 24 | (this.EhG >> 8 & 0xFF) << 8 | this.EhG & 0xFF);
      this.lHk.setAlpha(paramFloat);
      this.Ehx.setImageAlpha(i);
      this.mLS.setImageAlpha(i);
      this.Ehz.setImageAlpha(i);
      AppMethodBeat.o(198075);
      return;
      this.Ehx.setVisibility(0);
    }
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.vNr = paramInt;
    this.mLS.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new v(paramBundle))
    {
      this.EhD = paramBundle;
      AppMethodBeat.o(78397);
      return;
    }
  }
  
  protected void setImmersiveStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(198073);
    ae.i("MicroMsg.GameWebViewActionBar", "setImmersiveStyle");
    com.tencent.mm.ui.statusbar.b localb = this.Ehv;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.statusbar.a.e(localb, 0, bool);
      this.zoq.setBackgroundColor(0);
      this.lHk.setVisibility(8);
      this.Ehx.setVisibility(8);
      this.mLS.setImageAlpha(255);
      this.Ehz.setImageAlpha(255);
      if (!paramBoolean) {
        break;
      }
      this.mLS.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198065);
          m.c(m.this).setColorFilter(-1);
          AppMethodBeat.o(198065);
        }
      });
      if (this.EhF) {
        break label160;
      }
      this.Ehz.setImageResource(2131689500);
      AppMethodBeat.o(198073);
      return;
    }
    this.mLS.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198066);
        m.c(m.this).setColorFilter(-16777216);
        AppMethodBeat.o(198066);
      }
    });
    if (!this.EhF) {
      this.Ehz.setImageResource(2131689493);
    }
    label160:
    AppMethodBeat.o(198073);
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
    final int i = e.ee(str3, -16777216);
    final int j = (int)e.aJZ(str4);
    paramBundle = localObject;
    if (!bu.isNullOrNil(str2)) {}
    try
    {
      paramBundle = e.aKa(str2);
      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(198070);
          if ((m.this == null) || (m.a(m.this) == null))
          {
            AppMethodBeat.o(198070);
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
            AppMethodBeat.o(198070);
            return;
            m.a(m.this, false);
            if ((m.d(m.this) == null) || (m.e(m.this) == null))
            {
              AppMethodBeat.o(198070);
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
              if (!bu.isNullOrNil(str1))
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
        ae.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { paramBundle });
        paramBundle = localObject;
      }
    }
  }
  
  public void setOptionEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(78385);
    if (paramBoolean)
    {
      this.Ehz.setClickable(true);
      this.EhA.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.Ehz.setClickable(false);
    this.EhA.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.lHk.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    ae.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.lHk.setText(paramString);
    AppMethodBeat.o(78386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */