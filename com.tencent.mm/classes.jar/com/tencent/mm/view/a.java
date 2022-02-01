package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.p;
import com.tencent.mm.api.y.a;
import com.tencent.mm.api.z;
import com.tencent.mm.api.z.a;
import com.tencent.mm.bu.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ap;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean GuP = true;
  protected g[] HUh;
  private View HUi;
  private com.tencent.mm.view.footer.a HUj;
  private View HUk;
  private View HUl;
  private PhotoEditText HUm;
  private Switch HUn;
  private com.tencent.mm.view.b.a cHP;
  private y.a cJA;
  public boolean cJE = true;
  private b cRz;
  private View lEz;
  private Button pSG;
  private Button tLH;
  public ChatFooterPanel tlz;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract com.tencent.mm.view.b.a fio();
  
  protected abstract com.tencent.mm.view.footer.a fip();
  
  public View getActionBar()
  {
    if (this.lEz == null)
    {
      this.lEz = LayoutInflater.from(getContext()).inflate(2131495089, null);
      if (!ai.aF(getContext())) {
        break label122;
      }
    }
    label122:
    for (int i = ai.aE(getContext()) + 0;; i = 0)
    {
      this.lEz.setPadding(0, i, 0, 0);
      this.tLH = ((Button)this.lEz.findViewById(2131299265));
      this.tLH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9348);
          if (a.this.getTextEditView().getVisibility() == 0)
          {
            paramAnonymousView = a.this.getPresenter();
            Editable localEditable = a.b(a.this).getText();
            int j = a.b(a.this).getCurrentTextColor();
            if (a.c(a.this).isChecked()) {}
            for (int i = ((Integer)a.c(a.this).getTag()).intValue();; i = 0)
            {
              paramAnonymousView.a(localEditable, j, i);
              AppMethodBeat.o(9348);
              return;
            }
          }
          a.this.getPresenter().onFinish();
          AppMethodBeat.o(9348);
        }
      });
      this.pSG = ((Button)this.lEz.findViewById(2131299263));
      this.pSG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          if (a.this.getTextEditView().getVisibility() == 0)
          {
            a.this.getPresenter().eBs();
            AppMethodBeat.o(9354);
            return;
          }
          a.this.getPresenter().onExit();
          AppMethodBeat.o(9354);
        }
      });
      return this.lEz;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.cHP == null) {
      this.cHP = fio();
    }
    return this.cHP;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.HUj == null) {
      this.HUj = fip();
    }
    return this.HUj;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.tlz == null) {}
    try
    {
      this.tlz = aa.bg(getContext());
      this.tlz.setEntranceScene(ChatFooterPanel.BUV);
      this.tlz.setShowSmiley(false);
      this.tlz.setShowClose(true);
      this.tlz.setVisibility(8);
      this.tlz.onResume();
      z localz = aa.Kf();
      localz.cJL = new z.a()
      {
        public final void a(p paramAnonymousp)
        {
          AppMethodBeat.i(9357);
          ad.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousp });
          a.this.getPresenter().c(paramAnonymousp);
          onHide();
          AppMethodBeat.o(9357);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(9358);
          a.this.setActionBarVisible(true);
          a.this.xh(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.tlz.setCallback(localz);
      return this.tlz;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (getContext() == null) {
        bool = true;
      }
      ad.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", new Object[] { str, Boolean.valueOf(bool) });
      throw localException;
    }
  }
  
  public y.a getConfig()
  {
    return this.cJA;
  }
  
  public abstract g[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.HUi == null)
    {
      this.HUi = LayoutInflater.from(getContext()).inflate(2131494159, null);
      this.HUi.setVisibility(8);
    }
    return this.HUi;
  }
  
  public b getPresenter()
  {
    if (this.cRz == null)
    {
      this.cRz = new com.tencent.mm.bu.a();
      this.cRz.a(this);
    }
    return this.cRz;
  }
  
  public View getRubbishView()
  {
    if (this.HUk == null) {
      this.HUl = LayoutInflater.from(getContext()).inflate(2131495278, this, false);
    }
    return this.HUl;
  }
  
  public View getTextEditView()
  {
    if (this.HUk == null)
    {
      this.HUk = LayoutInflater.from(getContext()).inflate(2131493741, null);
      this.HUm = ((PhotoEditText)this.HUk.findViewById(2131305727));
      int k = (int)this.HUm.getResources().getDimension(2131166167);
      int j = (int)this.HUm.getResources().getDimension(2131166048);
      int i = j;
      if (ai.aF(getContext())) {
        i = j + ai.aE(getContext());
      }
      this.HUm.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.HUk.findViewById(2131304505);
      this.HUn = ((Switch)this.HUk.findViewById(2131297210));
      this.HUn.setTag(Integer.valueOf(-707825));
      this.HUn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9355);
          if (paramAnonymousBoolean)
          {
            localSelectColorBar.setSelectColor(((Integer)a.c(a.this).getTag()).intValue());
            a.b(a.this).setTextBackground(((Integer)a.c(a.this).getTag()).intValue());
            AppMethodBeat.o(9355);
            return;
          }
          a.c(a.this).setTag(Integer.valueOf(localSelectColorBar.getCurColor()));
          a.b(a.this).setTextBackground(0);
          AppMethodBeat.o(9355);
        }
      });
      this.HUm.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void abf(int paramAnonymousInt)
        {
          AppMethodBeat.i(9356);
          if (a.c(a.this).isChecked())
          {
            a.c(a.this).setTag(Integer.valueOf(paramAnonymousInt));
            a.b(a.this).setTextBackground(paramAnonymousInt);
            AppMethodBeat.o(9356);
            return;
          }
          a.b(a.this).setTextColor(paramAnonymousInt);
          AppMethodBeat.o(9356);
        }
      });
    }
    return this.HUk;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9359);
        a.this.getPresenter().onAttachedToWindow();
        AppMethodBeat.o(9359);
      }
    });
  }
  
  public void onGlobalLayout()
  {
    if (getTextEditView().getVisibility() == 0)
    {
      getViewTreeObserver().removeOnGlobalLayoutListener(this);
      this.HUm.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9353);
          Rect localRect = new Rect();
          a.this.getWindowVisibleDisplayFrame(localRect);
          int i;
          if (a.this.getBottom() - localRect.bottom >= 300)
          {
            i = 1;
            a.this.getResources().getDisplayMetrics();
            if (i != 0) {
              break label144;
            }
            i = a.this.getBottom() - (int)a.this.getResources().getDimension(2131166048);
          }
          for (;;)
          {
            if (a.b(a.this).getHeight() != i) {
              a.b(a.this).setHeight(i);
            }
            a.this.getViewTreeObserver().removeOnGlobalLayoutListener(a.this);
            a.this.getViewTreeObserver().addOnGlobalLayoutListener(a.this);
            AppMethodBeat.o(9353);
            return;
            i = 0;
            break;
            label144:
            i = a.this.getBottom() - com.tencent.mm.compatible.util.i.XP() - (int)a.this.getResources().getDimension(2131166048);
            ad.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
          }
        }
      }, 160L);
    }
  }
  
  public void setActionBarCallback(com.tencent.mm.api.i parami)
  {
    getPresenter().setActionBarCallback(parami);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.cJE == paramBoolean)
    {
      ad.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.cJE = paramBoolean;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771981);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9360);
          a.this.getActionBar().setVisibility(0);
          a.this.getFooterBg().setVisibility(0);
          AppMethodBeat.o(9360);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      getActionBar().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771982);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9361);
        a.this.getActionBar().setVisibility(8);
        a.this.getFooterBg().setVisibility(8);
        AppMethodBeat.o(9361);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
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
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771981);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9362);
          a.this.getFooterBg().setVisibility(0);
          a.this.getActionBar().setVisibility(0);
          AppMethodBeat.o(9362);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      getActionBar().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771982);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9349);
        a.this.getFooterBg().setVisibility(8);
        a.this.getActionBar().setVisibility(8);
        AppMethodBeat.o(9349);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    getActionBar().startAnimation(localAnimation);
  }
  
  public void setFooterVisible(boolean paramBoolean)
  {
    if ((this.GuP != paramBoolean) && (getConfig().cJE))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.GuP = paramBoolean;
    }
  }
  
  public void setup(y.a parama)
  {
    this.cJA = parama;
    getPresenter().a(getConfig());
    removeAllViews();
    parama = new FrameLayout.LayoutParams(-1, -1);
    addView(getBaseBoardView(), parama);
    parama = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131166287));
    parama.gravity = 80;
    addView(getFooterBg(), parama);
    addView(getBaseFooterView(), parama);
    parama = new FrameLayout.LayoutParams(-1, -1);
    getTextEditView().setVisibility(8);
    addView(getTextEditView(), parama);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    parama = (FrameLayout.LayoutParams)getRubbishView().getLayoutParams();
    parama.gravity = 81;
    parama.bottomMargin += ap.eb(getContext());
    parama.bottomMargin += com.tencent.mm.cd.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, aa.bh(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += ap.eb(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131165251)).gravity = 48;
    if (this.cJA.cJE)
    {
      addView(getActionBar());
      return;
    }
    getBaseFooterView().setVisibility(8);
  }
  
  public final void xh(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.tlz.getVisibility() == 0) && (paramBoolean))
    {
      this.tlz.setVisibility(8);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772106);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9351);
          a.d(a.this).setVisibility(8);
          AppMethodBeat.o(9351);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9350);
          a.d(a.this).setVisibility(0);
          AppMethodBeat.o(9350);
        }
      });
      this.tlz.startAnimation(localAnimation);
    }
    while ((this.tlz.getVisibility() != 8) || (paramBoolean)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772108);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9352);
        a.d(a.this).setVisibility(0);
        AppMethodBeat.o(9352);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.tlz.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */