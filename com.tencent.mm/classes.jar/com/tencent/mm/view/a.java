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
import com.tencent.mm.api.d;
import com.tencent.mm.api.f;
import com.tencent.mm.api.q.a;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.bo.a.d;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.bo.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import com.tencent.mm.view.footer.SelectColorBar;

public abstract class a
  extends com.tencent.mm.api.b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private q.a buT;
  public boolean buX = true;
  private com.tencent.mm.view.b.a buz;
  private com.tencent.mm.bt.b bzV;
  private View heP;
  private Button jRz;
  private Button mqX;
  public ChatFooterPanel wvA;
  private PhotoEditText wvB;
  private Switch wvC;
  private boolean wvD = true;
  protected d[] wvv;
  private View wvw;
  private com.tencent.mm.view.footer.a wvx;
  private View wvy;
  private View wvz;
  
  public a(Context paramContext, q.a parama)
  {
    super(paramContext);
    this.buT = parama;
    getPresenter().a(getConfig());
    removeAllViews();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(getBaseBoardView(), paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(a.c.feature_select_all_layout_height));
    paramContext.gravity = 80;
    addView(getFooterBg(), paramContext);
    addView(getBaseFooterView(), paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    getTextEditView().setVisibility(8);
    addView(getTextEditView(), paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(a.c.emoji_feature_layout_height));
    paramContext.gravity = 80;
    addView(getChatFooterPanel(), paramContext);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(a.c.DefaultActionbarHeightLand)).gravity = 48;
    if (this.buT.buX) {
      addView(getActionBar());
    }
  }
  
  protected abstract com.tencent.mm.view.b.a cLu();
  
  protected abstract com.tencent.mm.view.footer.a cLv();
  
  public View getActionBar()
  {
    if (this.heP == null)
    {
      this.heP = LayoutInflater.from(getContext()).inflate(a.f.photoedit_actionbar_view, null);
      if (!ak.gC(getContext())) {
        break label125;
      }
    }
    label125:
    for (int i = ak.gB(getContext()) + 0;; i = 0)
    {
      this.heP.setPadding(0, i, 0, 0);
      this.mqX = ((Button)this.heP.findViewById(a.e.edit_text_ok));
      this.mqX.setOnClickListener(new a.1(this));
      this.jRz = ((Button)this.heP.findViewById(a.e.edit_text_cancel));
      this.jRz.setOnClickListener(new a.6(this));
      return this.heP;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.buz == null) {
      this.buz = cLu();
    }
    return this.buz;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.wvx == null) {
      this.wvx = cLv();
    }
    return this.wvx;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.wvA == null) {}
    try
    {
      this.wvA = s.ay(getContext());
      this.wvA.setEntranceScene(ChatFooterPanel.rZw);
      this.wvA.setBackgroundResource(a.d.bottombar_bg);
      this.wvA.sl();
      this.wvA.aN(true);
      this.wvA.i(true, true);
      this.wvA.setVisibility(8);
      this.wvA.onResume();
      r localr = s.so();
      localr.bvd = new a.9(this);
      this.wvA.setCallback(localr);
      return this.wvA;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (getContext() == null) {
        bool = true;
      }
      y.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", new Object[] { str, Boolean.valueOf(bool) });
      throw localException;
    }
  }
  
  public q.a getConfig()
  {
    return this.buT;
  }
  
  public abstract d[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.wvw == null)
    {
      this.wvw = LayoutInflater.from(getContext()).inflate(a.f.footer_bg_view, null);
      this.wvw.setVisibility(0);
    }
    return this.wvw;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    if (this.bzV == null)
    {
      this.bzV = new com.tencent.mm.bt.a();
      this.bzV.a(this);
    }
    return this.bzV;
  }
  
  public View getRubbishView()
  {
    if (this.wvy == null) {
      this.wvz = LayoutInflater.from(getContext()).inflate(a.f.rubbish_view, null);
    }
    return this.wvz;
  }
  
  public View getTextEditView()
  {
    if (this.wvy == null)
    {
      this.wvy = LayoutInflater.from(getContext()).inflate(a.f.edit_text_view, null);
      this.wvB = ((PhotoEditText)this.wvy.findViewById(a.e.text_edit));
      SelectColorBar localSelectColorBar = (SelectColorBar)this.wvy.findViewById(a.e.select_color_bar);
      this.wvC = ((Switch)this.wvy.findViewById(a.e.bg_switch));
      this.wvC.setTag(Integer.valueOf(-707825));
      this.wvC.setOnCheckedChangeListener(new a.7(this, localSelectColorBar));
      this.wvB.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new a.8(this));
    }
    return this.wvy;
  }
  
  public final void od(boolean paramBoolean)
  {
    y.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.wvA.getVisibility() == 0) && (paramBoolean))
    {
      this.wvA.setVisibility(8);
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.push_down_out);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          a.d(a.this).setVisibility(8);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          a.d(a.this).setVisibility(0);
        }
      });
      this.wvA.startAnimation(localAnimation);
    }
    while ((this.wvA.getVisibility() != 8) || (paramBoolean)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.push_up_in);
    localAnimation.setAnimationListener(new a.4(this));
    this.wvA.startAnimation(localAnimation);
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
      this.wvB.postDelayed(new a.5(this), 160L);
    }
  }
  
  public void setActionBarCallback(f paramf)
  {
    getPresenter().setActionBarCallback(paramf);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.buX == paramBoolean)
    {
      y.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.buX = paramBoolean;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_in);
      localAnimation.setAnimationListener(new a.11(this));
      getActionBar().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_out);
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
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_in);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          a.this.getFooterBg().setVisibility(0);
          a.this.getActionBar().setVisibility(0);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      getActionBar().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_out);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        a.this.getFooterBg().setVisibility(8);
        a.this.getActionBar().setVisibility(8);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    getActionBar().startAnimation(localAnimation);
  }
  
  public void setFooterVisible(boolean paramBoolean)
  {
    if (this.wvD != paramBoolean)
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.wvD = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */