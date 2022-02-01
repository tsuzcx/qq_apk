package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.api.i;
import com.tencent.mm.api.p;
import com.tencent.mm.api.y.a;
import com.tencent.mm.api.z;
import com.tencent.mm.api.z.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean JJe = true;
  protected g[] LnR;
  private View LnS;
  private com.tencent.mm.view.footer.a LnT;
  private View LnU;
  private View LnV;
  private PhotoEditText LnW;
  private Switch LnX;
  private com.tencent.mm.view.b.a cQc;
  private y.a cRL;
  public boolean cRP = true;
  private com.tencent.mm.bu.b dak;
  private View mGU;
  private Button rle;
  private Button vXv;
  public ChatFooterPanel vwv;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract com.tencent.mm.view.b.a fPK();
  
  protected abstract com.tencent.mm.view.footer.a fPL();
  
  public View getActionBar()
  {
    if (this.mGU == null)
    {
      this.mGU = LayoutInflater.from(getContext()).inflate(2131495089, null);
      if (!al.aG(getContext())) {
        break label122;
      }
    }
    label122:
    for (int i = al.aF(getContext()) + 0;; i = 0)
    {
      this.mGU.setPadding(0, i, 0, 0);
      this.vXv = ((Button)this.mGU.findViewById(2131299265));
      this.vXv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9348);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          int i;
          if (a.this.getTextEditView().getVisibility() == 0)
          {
            paramAnonymousView = a.this.getPresenter();
            localObject = a.b(a.this).getText();
            int j = a.b(a.this).getCurrentTextColor();
            if (a.c(a.this).isChecked())
            {
              i = ((Integer)a.c(a.this).getTag()).intValue();
              paramAnonymousView.a((Editable)localObject, j, i);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(9348);
            return;
            i = 0;
            break;
            a.this.getPresenter().onFinish();
          }
        }
      });
      this.rle = ((Button)this.mGU.findViewById(2131299263));
      this.rle.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (a.this.getTextEditView().getVisibility() == 0) {
            a.this.getPresenter().ffQ();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(9354);
            return;
            a.this.getPresenter().onExit();
          }
        }
      });
      return this.mGU;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.cQc == null) {
      this.cQc = fPK();
    }
    return this.cQc;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.LnT == null) {
      this.LnT = fPL();
    }
    return this.LnT;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.vwv == null) {}
    try
    {
      this.vwv = aa.bh(getContext());
      this.vwv.setEntranceScene(ChatFooterPanel.ESq);
      this.vwv.setShowSmiley(false);
      this.vwv.setShowClose(true);
      this.vwv.setVisibility(8);
      this.vwv.onResume();
      z localz = aa.Lo();
      localz.cRW = new z.a()
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
          a.this.zd(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.vwv.setCallback(localz);
      return this.vwv;
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
    return this.cRL;
  }
  
  public abstract g[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.LnS == null)
    {
      this.LnS = LayoutInflater.from(getContext()).inflate(2131494159, null);
      this.LnS.setVisibility(8);
    }
    return this.LnS;
  }
  
  public com.tencent.mm.bu.b getPresenter()
  {
    if (this.dak == null)
    {
      this.dak = new com.tencent.mm.bu.a();
      this.dak.a(this);
    }
    return this.dak;
  }
  
  public View getRubbishView()
  {
    if (this.LnU == null) {
      this.LnV = LayoutInflater.from(getContext()).inflate(2131495278, this, false);
    }
    return this.LnV;
  }
  
  public View getTextEditView()
  {
    if (this.LnU == null)
    {
      this.LnU = LayoutInflater.from(getContext()).inflate(2131493741, null);
      this.LnW = ((PhotoEditText)this.LnU.findViewById(2131305727));
      int k = (int)this.LnW.getResources().getDimension(2131166167);
      int j = (int)this.LnW.getResources().getDimension(2131166048);
      int i = j;
      if (al.aG(getContext())) {
        i = j + al.aF(getContext());
      }
      this.LnW.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.LnU.findViewById(2131304505);
      this.LnX = ((Switch)this.LnU.findViewById(2131297210));
      this.LnX.setTag(Integer.valueOf(-707825));
      this.LnX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.LnW.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void TD(int paramAnonymousInt)
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
    return this.LnU;
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
      this.LnW.postDelayed(new a.5(this), 160L);
    }
  }
  
  public void setActionBarCallback(i parami)
  {
    getPresenter().setActionBarCallback(parami);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.cRP == paramBoolean)
    {
      ad.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.cRP = paramBoolean;
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
    if ((this.JJe != paramBoolean) && (getConfig().cRP))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.JJe = paramBoolean;
    }
  }
  
  public void setup(y.a parama)
  {
    this.cRL = parama;
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
    parama.bottomMargin += ar.ej(getContext());
    parama.bottomMargin += com.tencent.mm.cc.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, aa.bi(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += ar.ej(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131165251)).gravity = 48;
    if (this.cRL.cRP)
    {
      addView(getActionBar());
      return;
    }
    getBaseFooterView().setVisibility(8);
  }
  
  public final void zd(boolean paramBoolean)
  {
    ad.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.vwv.getVisibility() == 0) && (paramBoolean))
    {
      this.vwv.setVisibility(8);
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
      this.vwv.startAnimation(localAnimation);
    }
    while ((this.vwv.getVisibility() != 8) || (paramBoolean)) {
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
    this.vwv.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */