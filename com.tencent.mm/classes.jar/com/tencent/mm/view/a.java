package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.s.a;
import com.tencent.mm.api.t;
import com.tencent.mm.api.u;
import com.tencent.mm.bs.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.footer.SelectColorBar;

public abstract class a
  extends c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private PhotoEditText AQA;
  private Switch AQB;
  private boolean AQC = true;
  protected e[] AQv;
  private View AQw;
  private com.tencent.mm.view.footer.a AQx;
  private View AQy;
  private View AQz;
  private com.tencent.mm.view.b.a bVK;
  private s.a bWd;
  public boolean bWh = true;
  private b ccS;
  private View iQc;
  private Button mlV;
  private Button oQM;
  public ChatFooterPanel osX;
  
  public a(Context paramContext, s.a parama)
  {
    super(paramContext);
    this.bWd = parama;
    getPresenter().a(getConfig());
    removeAllViews();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(getBaseBoardView(), paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131428421));
    paramContext.gravity = 80;
    addView(getFooterBg(), paramContext);
    addView(getBaseFooterView(), paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    getTextEditView().setVisibility(8);
    addView(getTextEditView(), paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    paramContext = (FrameLayout.LayoutParams)getRubbishView().getLayoutParams();
    paramContext.gravity = 81;
    paramContext.bottomMargin += am.fx(getContext());
    paramContext.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131428357));
    paramContext.gravity = 80;
    paramContext.bottomMargin += am.fx(getContext());
    addView(getChatFooterPanel(), paramContext);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131427558)).gravity = 48;
    if (this.bWd.bWh) {
      addView(getActionBar());
    }
  }
  
  protected abstract com.tencent.mm.view.b.a dQM();
  
  protected abstract com.tencent.mm.view.footer.a dQN();
  
  public View getActionBar()
  {
    if (this.iQc == null)
    {
      this.iQc = LayoutInflater.from(getContext()).inflate(2130970420, null);
      if (!af.hW(getContext())) {
        break label122;
      }
    }
    label122:
    for (int i = af.hV(getContext()) + 0;; i = 0)
    {
      this.iQc.setPadding(0, i, 0, 0);
      this.oQM = ((Button)this.iQc.findViewById(2131826739));
      this.oQM.setOnClickListener(new a.1(this));
      this.mlV = ((Button)this.iQc.findViewById(2131826738));
      this.mlV.setOnClickListener(new a.6(this));
      return this.iQc;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.bVK == null) {
      this.bVK = dQM();
    }
    return this.bVK;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.AQx == null) {
      this.AQx = dQN();
    }
    return this.AQx;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.osX == null) {}
    try
    {
      this.osX = u.aW(getContext());
      this.osX.setEntranceScene(ChatFooterPanel.vQo);
      this.osX.setBackgroundResource(2130838022);
      this.osX.AA();
      this.osX.bo(true);
      this.osX.j(true, true);
      this.osX.setVisibility(8);
      this.osX.onResume();
      t localt = u.AF();
      localt.bWo = new a.9(this);
      this.osX.setCallback(localt);
      return this.osX;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (getContext() == null) {
        bool = true;
      }
      ab.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", new Object[] { str, Boolean.valueOf(bool) });
      throw localException;
    }
  }
  
  public s.a getConfig()
  {
    return this.bWd;
  }
  
  public abstract e[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.AQw == null)
    {
      this.AQw = LayoutInflater.from(getContext()).inflate(2130969618, null);
      this.AQw.setVisibility(0);
    }
    return this.AQw;
  }
  
  public b getPresenter()
  {
    if (this.ccS == null)
    {
      this.ccS = new com.tencent.mm.bs.a();
      this.ccS.a(this);
    }
    return this.ccS;
  }
  
  public View getRubbishView()
  {
    if (this.AQy == null) {
      this.AQz = LayoutInflater.from(getContext()).inflate(2130970593, this, false);
    }
    return this.AQz;
  }
  
  public View getTextEditView()
  {
    if (this.AQy == null)
    {
      this.AQy = LayoutInflater.from(getContext()).inflate(2130969352, null);
      this.AQA = ((PhotoEditText)this.AQy.findViewById(2131823497));
      int k = (int)this.AQA.getResources().getDimension(2131428316);
      int j = (int)this.AQA.getResources().getDimension(2131428235);
      int i = j;
      if (af.hW(getContext())) {
        i = j + af.hV(getContext());
      }
      this.AQA.setPadding(k, i, k, 0);
      SelectColorBar localSelectColorBar = (SelectColorBar)this.AQy.findViewById(2131823499);
      this.AQB = ((Switch)this.AQy.findViewById(2131823498));
      this.AQB.setTag(Integer.valueOf(-707825));
      this.AQB.setOnCheckedChangeListener(new a.7(this, localSelectColorBar));
      this.AQA.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new a.8(this));
    }
    return this.AQy;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    post(new a.10(this));
  }
  
  public void onGlobalLayout()
  {
    if (getTextEditView().getVisibility() == 0)
    {
      getViewTreeObserver().removeOnGlobalLayoutListener(this);
      this.AQA.postDelayed(new a.5(this), 160L);
    }
  }
  
  public final void rN(boolean paramBoolean)
  {
    ab.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.osX.getVisibility() == 0) && (paramBoolean))
    {
      this.osX.setVisibility(8);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034228);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(116374);
          a.d(a.this).setVisibility(8);
          AppMethodBeat.o(116374);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(116373);
          a.d(a.this).setVisibility(0);
          AppMethodBeat.o(116373);
        }
      });
      this.osX.startAnimation(localAnimation);
    }
    while ((this.osX.getVisibility() != 8) || (paramBoolean)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034230);
    localAnimation.setAnimationListener(new a.4(this));
    this.osX.startAnimation(localAnimation);
  }
  
  public void setActionBarCallback(g paramg)
  {
    getPresenter().setActionBarCallback(paramg);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.bWh == paramBoolean)
    {
      ab.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.bWh = paramBoolean;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034125);
      localAnimation.setAnimationListener(new a.11(this));
      getActionBar().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034126);
    localAnimation.setAnimationListener(new a.12(this));
    getActionBar().startAnimation(localAnimation);
  }
  
  public void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    getPresenter().setAutoShowFooterAndBar(paramBoolean);
  }
  
  public void setFooterBgVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034125);
      localAnimation.setAnimationListener(new a.13(this));
      getActionBar().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2131034126);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(116372);
        a.this.getFooterBg().setVisibility(8);
        a.this.getActionBar().setVisibility(8);
        AppMethodBeat.o(116372);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    getActionBar().startAnimation(localAnimation);
  }
  
  public void setFooterVisible(boolean paramBoolean)
  {
    if (this.AQC != paramBoolean)
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.AQC = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */