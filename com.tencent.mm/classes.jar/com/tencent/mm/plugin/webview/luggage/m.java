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
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import org.json.JSONArray;
import org.json.JSONObject;

public class m
  extends FrameLayout
{
  private View DuB;
  private g ISU;
  public com.tencent.mm.ui.statusbar.b IUh;
  private View IUi;
  private ImageView IUj;
  protected LinearLayout IUk;
  private ImageView IUl;
  private TextView IUm;
  private o IUn;
  protected n IUo;
  private x IUp;
  public com.tencent.mm.ui.widget.a.d IUq;
  private boolean IUr;
  private int IUs;
  private boolean IUt;
  private boolean IUu;
  int IUv;
  private boolean IUw;
  public Integer IUx;
  public boolean IUy;
  private View.OnClickListener IUz;
  protected Context mContext;
  private TextView mPa;
  private String mTitle;
  private ImageView nZa;
  private int ziP;
  
  public m(g paramg)
  {
    super(paramg.mContext);
    AppMethodBeat.i(78384);
    this.IUq = null;
    this.IUr = false;
    this.IUv = -1;
    this.ziP = 2131689510;
    this.IUw = false;
    this.IUz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210921);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (m.a(m.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210921);
          return;
        }
        m.a(m.this).ctS.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject Ld()
          {
            AppMethodBeat.i(210920);
            JSONObject localJSONObject = new JSONObject();
            AppMethodBeat.o(210920);
            return localJSONObject;
          }
          
          public final String name()
          {
            return "onNavigationBarRightButtonClick";
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(210921);
      }
    };
    setId(2131304291);
    this.mContext = paramg.mContext;
    this.ISU = paramg;
    setBackgroundColor(0);
    this.IUh = new c(this.mContext);
    addView(this.IUh, -1, -1);
    this.IUs = android.support.v4.content.b.n(this.mContext, 2131099891);
    this.DuB = aa.jQ(getContext()).inflate(2131497064, this, false);
    setActionBarViewColor(this.IUs);
    this.IUh.addView(this.DuB, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.IUi = this.DuB.findViewById(2131304497);
    this.IUj = ((ImageView)this.DuB.findViewById(2131299682));
    this.nZa = ((ImageView)this.DuB.findViewById(2131296421));
    this.nZa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!m.this.gbB()) {
          m.this.dTG();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78375);
      }
    });
    this.mPa = ((TextView)this.DuB.findViewById(2131309195));
    this.IUk = ((LinearLayout)this.DuB.findViewById(2131296440));
    this.IUl = ((ImageView)this.DuB.findViewById(2131296439));
    this.IUl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        m.this.dTH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78376);
      }
    });
    this.IUl.setClickable(false);
    this.IUm = ((TextView)this.DuB.findViewById(2131296441));
    this.IUm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        m.this.dTH();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/LuggageWebActionBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(78377);
      }
    });
    this.IUm.setClickable(false);
    if (com.tencent.mm.cb.a.jk(getContext())) {
      this.mPa.setTextSize(0, com.tencent.mm.cb.a.aH(getContext(), 2131165203) * com.tencent.mm.cb.a.ji(getContext()));
    }
    AppMethodBeat.o(78384);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(78391);
    int i = au.eu(MMApplicationContext.getContext());
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
      i = getResources().getColor(2131101424);
    }
    boolean bool2 = ze(ar.aln(i));
    com.tencent.mm.ui.statusbar.b localb = this.IUh;
    if (!bool2) {}
    for (;;)
    {
      com.tencent.mm.ui.statusbar.a.e(localb, i, bool1);
      this.IUx = Integer.valueOf(i);
      this.IUy = bool2;
      setActionBarViewColor(i);
      pK(bool2);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
  }
  
  private void setActionBarViewColor(int paramInt)
  {
    AppMethodBeat.i(210930);
    if (this.DuB != null)
    {
      this.DuB.setBackgroundColor(paramInt);
      if ((paramInt >> 24 & 0xFF) / 255.0F > 0.0F)
      {
        this.DuB.setClickable(true);
        AppMethodBeat.o(210930);
        return;
      }
      this.DuB.setClickable(false);
    }
    AppMethodBeat.o(210930);
  }
  
  private void setImmersiveStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(210929);
    Log.i("MicroMsg.GameWebViewActionBar", "setImmersiveStyle");
    boolean bool = ze(paramBoolean);
    com.tencent.mm.ui.statusbar.b localb = this.IUh;
    if (!bool) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      com.tencent.mm.ui.statusbar.a.e(localb, 0, paramBoolean);
      this.IUx = Integer.valueOf(0);
      this.IUy = bool;
      setActionBarViewColor(0);
      this.mPa.setVisibility(8);
      this.IUj.setVisibility(8);
      this.nZa.setImageAlpha(255);
      this.IUl.setImageAlpha(255);
      pK(bool);
      AppMethodBeat.o(210929);
      return;
    }
  }
  
  private boolean ze(boolean paramBoolean)
  {
    switch (this.IUv)
    {
    default: 
      return paramBoolean;
    case 0: 
      return true;
    }
    return false;
  }
  
  public final void T(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78395);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().aYA(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78395);
  }
  
  public final void U(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78396);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().aYB(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void dTG()
  {
    AppMethodBeat.i(78392);
    this.ISU.hb(true);
    AppMethodBeat.o(78392);
  }
  
  public void dTH()
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
  
  public void dTI()
  {
    AppMethodBeat.i(78390);
    if (this.IUn != null) {
      this.IUn.gca();
    }
    AppMethodBeat.o(78390);
  }
  
  public final boolean gbB()
  {
    AppMethodBeat.i(78398);
    if ((this.IUp != null) && (this.IUp.gci()))
    {
      Object localObject1 = this.IUp.gcj();
      String str1 = this.IUp.gck();
      String str2 = this.IUp.gcl();
      Log.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
      View localView = View.inflate(getContext(), 2131495497, null);
      Object localObject2 = (CheckBox)localView.findViewById(2131304698);
      ((CheckBox)localObject2).setChecked(false);
      ((CheckBox)localObject2).setVisibility(8);
      localObject2 = (TextView)localView.findViewById(2131304700);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131100904));
      localObject1 = (TextView)localView.findViewById(2131304699);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131100904));
      ((TextView)localObject1).setVisibility(8);
      this.IUq = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          m.b(m.this);
          m.this.dTG();
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
  
  public final void gbW()
  {
    AppMethodBeat.i(210924);
    this.IUw = true;
    if (this.IUj != null) {
      this.IUj.setVisibility(8);
    }
    if (this.IUi != null) {
      this.IUi.setVisibility(8);
    }
    AppMethodBeat.o(210924);
  }
  
  public final void gbX()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().gbX();
    AppMethodBeat.o(78393);
  }
  
  public final void gbY()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().gbY();
    AppMethodBeat.o(78394);
  }
  
  public final void gbZ()
  {
    AppMethodBeat.i(210931);
    setImmersiveStyle(this.IUu);
    AppMethodBeat.o(210931);
  }
  
  protected n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.IUo == null) {
      this.IUo = new n();
    }
    n localn = this.IUo;
    AppMethodBeat.o(78388);
    return localn;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public int getTopBarHeight()
  {
    AppMethodBeat.i(210925);
    int i = this.IUh.getHeight();
    AppMethodBeat.o(210925);
    return i;
  }
  
  public final void k(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210927);
    this.IUs = paramInt;
    this.IUt = paramBoolean1;
    this.IUu = paramBoolean2;
    if ((this.IUt) && ((this.IUx == null) || (this.IUx.intValue() == 0)))
    {
      setImmersiveStyle(paramBoolean2);
      AppMethodBeat.o(210927);
      return;
    }
    setActionBarColor(paramInt);
    AppMethodBeat.o(210927);
  }
  
  public void onDestroy() {}
  
  public void onForeground() {}
  
  protected void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(210926);
    if (!paramBoolean)
    {
      this.mPa.setTextColor(-16777216);
      this.nZa.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78381);
          m.c(m.this).setColorFilter(-16777216);
          AppMethodBeat.o(78381);
        }
      }, 100L);
      if (!this.IUr)
      {
        this.IUl.setImageResource(2131689495);
        AppMethodBeat.o(210926);
      }
    }
    else
    {
      this.mPa.setTextColor(-1);
      this.nZa.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210922);
          m.c(m.this).setColorFilter(-1);
          AppMethodBeat.o(210922);
        }
      }, 100L);
      if (!this.IUr) {
        this.IUl.setImageResource(2131689502);
      }
    }
    AppMethodBeat.o(210926);
  }
  
  public void setActionBarColorValue(int paramInt)
  {
    this.IUs = paramInt;
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(210932);
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F))
    {
      AppMethodBeat.o(210932);
      return;
    }
    if (paramFloat == 0.0F)
    {
      gbZ();
      AppMethodBeat.o(210932);
      return;
    }
    int i = (int)(255.0F * paramFloat);
    this.mPa.setVisibility(0);
    if (this.IUw) {
      this.IUj.setVisibility(8);
    }
    for (;;)
    {
      setActionBarColor((this.IUs >> 16 & 0xFF) << 16 | i << 24 | (this.IUs >> 8 & 0xFF) << 8 | this.IUs & 0xFF);
      this.mPa.setAlpha(paramFloat);
      this.IUj.setImageAlpha(i);
      this.nZa.setImageAlpha(i);
      this.IUl.setImageAlpha(i);
      AppMethodBeat.o(210932);
      return;
      this.IUj.setVisibility(0);
    }
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.ziP = paramInt;
    this.nZa.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new x(paramBundle))
    {
      this.IUp = paramBundle;
      AppMethodBeat.o(78397);
      return;
    }
  }
  
  public void setIconDark(int paramInt)
  {
    this.IUv = paramInt;
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
    e.gw(str3, -16777216);
    final int i = (int)e.bag(str4);
    paramBundle = localObject;
    if (!Util.isNullOrNil(str2)) {}
    try
    {
      paramBundle = e.bah(str2);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210923);
          if ((m.this == null) || (m.a(m.this) == null))
          {
            AppMethodBeat.o(210923);
            return;
          }
          if (bool1)
          {
            m.a(m.this, true);
            AppMethodBeat.o(210923);
            return;
          }
          m.a(m.this, false);
          if ((m.d(m.this) == null) || (m.e(m.this) == null))
          {
            AppMethodBeat.o(210923);
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
            AppMethodBeat.o(210923);
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
      this.IUl.setClickable(true);
      this.IUm.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.IUl.setClickable(false);
    this.IUm.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.mPa.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    Log.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.mPa.setText(paramString);
    AppMethodBeat.o(78386);
  }
  
  final void zd(boolean paramBoolean)
  {
    AppMethodBeat.i(210928);
    if (this.IUl != null)
    {
      if (paramBoolean)
      {
        this.IUl.setVisibility(8);
        AppMethodBeat.o(210928);
        return;
      }
      this.IUl.setVisibility(0);
    }
    AppMethodBeat.o(210928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */