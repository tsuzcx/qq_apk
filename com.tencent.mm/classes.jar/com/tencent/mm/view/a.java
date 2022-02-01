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
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean PpR = true;
  private View RiA;
  private PhotoEditText RiB;
  private Switch RiC;
  protected h[] Riw;
  private View Rix;
  private com.tencent.mm.view.footer.a Riy;
  private View Riz;
  private com.tencent.mm.view.b.a dhg;
  private ab.a diP;
  public boolean diT = true;
  private com.tencent.mm.bt.b drS;
  private View nZg;
  private Button sTL;
  private Button zDY;
  private ChatFooterPanel zdv;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void DC(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.zdv.getVisibility() == 0) && (paramBoolean))
    {
      this.zdv.setVisibility(8);
      localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772130);
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
      this.zdv.startAnimation(localAnimation);
    }
    while ((this.zdv.getVisibility() != 8) || (paramBoolean)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772132);
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
    this.zdv.startAnimation(localAnimation);
  }
  
  public View getActionBar()
  {
    if (this.nZg == null)
    {
      this.nZg = LayoutInflater.from(getContext()).inflate(2131495927, null);
      if (!ao.aQ(getContext())) {
        break label122;
      }
    }
    label122:
    for (int i = ao.aP(getContext()) + 0;; i = 0)
    {
      this.nZg.setPadding(0, i, 0, 0);
      this.zDY = ((Button)this.nZg.findViewById(2131299843));
      this.zDY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9348);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
      this.sTL = ((Button)this.nZg.findViewById(2131299840));
      this.sTL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (a.this.getTextEditView().getVisibility() == 0) {
            a.this.getPresenter().gtg();
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
      return this.nZg;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.dhg == null) {
      this.dhg = hfv();
    }
    return this.dhg;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.Riy == null) {
      this.Riy = hfw();
    }
    return this.Riy;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.zdv == null) {}
    try
    {
      this.zdv = ad.bC(getContext());
      this.zdv.setEntranceScene(ChatFooterPanel.KbD);
      this.zdv.setShowSmiley(false);
      this.zdv.setShowClose(true);
      this.zdv.setVisibility(8);
      this.zdv.onResume();
      ac localac = ad.VK();
      localac.djc = new ac.a()
      {
        public final void a(r paramAnonymousr)
        {
          AppMethodBeat.i(9357);
          Log.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousr });
          a.this.getPresenter().c(paramAnonymousr);
          onHide();
          AppMethodBeat.o(9357);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(9358);
          a.this.setActionBarVisible(true);
          a.this.DC(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.zdv.setCallback(localac);
      return this.zdv;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (getContext() == null) {
        bool = true;
      }
      Log.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", new Object[] { str, Boolean.valueOf(bool) });
      throw localException;
    }
  }
  
  public ab.a getConfig()
  {
    return this.diP;
  }
  
  public abstract h[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.Rix == null)
    {
      this.Rix = LayoutInflater.from(getContext()).inflate(2131494714, null);
      this.Rix.setVisibility(8);
    }
    return this.Rix;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    if (this.drS == null)
    {
      this.drS = new com.tencent.mm.bt.a();
      this.drS.a(this);
    }
    return this.drS;
  }
  
  public View getRubbishView()
  {
    if (this.Riz == null) {
      this.RiA = LayoutInflater.from(getContext()).inflate(2131496128, this, false);
    }
    return this.RiA;
  }
  
  public View getTextEditView()
  {
    if (this.Riz == null)
    {
      this.Riz = LayoutInflater.from(getContext()).inflate(2131493876, null);
      this.RiB = ((PhotoEditText)this.Riz.findViewById(2131308994));
      int k = (int)this.RiB.getResources().getDimension(2131166208);
      int j = (int)this.RiB.getResources().getDimension(2131166088);
      int i = j;
      if (ao.aQ(getContext())) {
        i = j + ao.aP(getContext());
      }
      this.RiB.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.Riz.findViewById(2131307511);
      this.RiC = ((Switch)this.Riz.findViewById(2131297362));
      this.RiC.setTag(Integer.valueOf(-707825));
      this.RiC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.RiB.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void acC(int paramAnonymousInt)
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
    return this.Riz;
  }
  
  protected abstract com.tencent.mm.view.b.a hfv();
  
  protected abstract com.tencent.mm.view.footer.a hfw();
  
  public final boolean hfx()
  {
    return (this.zdv.getVisibility() == 0) || (getTextEditView().getVisibility() == 0);
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
      this.RiB.postDelayed(new a.5(this), 160L);
    }
  }
  
  public void setActionBarCallback(j paramj)
  {
    getPresenter().setActionBarCallback(paramj);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.diT == paramBoolean)
    {
      Log.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.diT = paramBoolean;
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
    if ((this.PpR != paramBoolean) && (getConfig().diT))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.PpR = paramBoolean;
    }
  }
  
  public void setup(ab.a parama)
  {
    this.diP = parama;
    getPresenter().a(getConfig());
    removeAllViews();
    parama = new FrameLayout.LayoutParams(-1, -1);
    addView(getBaseBoardView(), parama);
    parama = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131166334));
    parama.gravity = 80;
    addView(getFooterBg(), parama);
    addView(getBaseFooterView(), parama);
    parama = new FrameLayout.LayoutParams(-1, -1);
    getTextEditView().setVisibility(8);
    addView(getTextEditView(), parama);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    parama = (FrameLayout.LayoutParams)getRubbishView().getLayoutParams();
    parama.gravity = 81;
    parama.bottomMargin += au.aD(getContext());
    parama.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, ad.bD(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += au.aD(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131165255)).gravity = 48;
    if (this.diP.diT)
    {
      addView(getActionBar());
      return;
    }
    getBaseFooterView().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */