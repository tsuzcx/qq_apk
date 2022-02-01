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
import com.tencent.mm.bt.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ap;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean HUG = true;
  protected g[] JuP;
  private View JuQ;
  private com.tencent.mm.view.footer.a JuR;
  private View JuS;
  private View JuT;
  private PhotoEditText JuU;
  private Switch JuV;
  private com.tencent.mm.view.b.a cEX;
  private y.a cGH;
  public boolean cGL = true;
  private b cOU;
  private View mgu;
  private Button qBo;
  private Button uUl;
  public ChatFooterPanel utS;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract com.tencent.mm.view.b.a fyB();
  
  protected abstract com.tencent.mm.view.footer.a fyC();
  
  public View getActionBar()
  {
    if (this.mgu == null)
    {
      this.mgu = LayoutInflater.from(getContext()).inflate(2131495089, null);
      if (!aj.aG(getContext())) {
        break label122;
      }
    }
    label122:
    for (int i = aj.aF(getContext()) + 0;; i = 0)
    {
      this.mgu.setPadding(0, i, 0, 0);
      this.uUl = ((Button)this.mgu.findViewById(2131299265));
      this.uUl.setOnClickListener(new View.OnClickListener()
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
      this.qBo = ((Button)this.mgu.findViewById(2131299263));
      this.qBo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          if (a.this.getTextEditView().getVisibility() == 0)
          {
            a.this.getPresenter().eQM();
            AppMethodBeat.o(9354);
            return;
          }
          a.this.getPresenter().onExit();
          AppMethodBeat.o(9354);
        }
      });
      return this.mgu;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.cEX == null) {
      this.cEX = fyB();
    }
    return this.cEX;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.JuR == null) {
      this.JuR = fyC();
    }
    return this.JuR;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.utS == null) {}
    try
    {
      this.utS = aa.bh(getContext());
      this.utS.setEntranceScene(ChatFooterPanel.Dnl);
      this.utS.setShowSmiley(false);
      this.utS.setShowClose(true);
      this.utS.setVisibility(8);
      this.utS.onResume();
      z localz = aa.JP();
      localz.cGS = new z.a()
      {
        public final void a(p paramAnonymousp)
        {
          AppMethodBeat.i(9357);
          ac.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousp });
          a.this.getPresenter().c(paramAnonymousp);
          onHide();
          AppMethodBeat.o(9357);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(9358);
          a.this.setActionBarVisible(true);
          a.this.yq(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.utS.setCallback(localz);
      return this.utS;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (getContext() == null) {
        bool = true;
      }
      ac.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", new Object[] { str, Boolean.valueOf(bool) });
      throw localException;
    }
  }
  
  public y.a getConfig()
  {
    return this.cGH;
  }
  
  public abstract g[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.JuQ == null)
    {
      this.JuQ = LayoutInflater.from(getContext()).inflate(2131494159, null);
      this.JuQ.setVisibility(8);
    }
    return this.JuQ;
  }
  
  public b getPresenter()
  {
    if (this.cOU == null)
    {
      this.cOU = new com.tencent.mm.bt.a();
      this.cOU.a(this);
    }
    return this.cOU;
  }
  
  public View getRubbishView()
  {
    if (this.JuS == null) {
      this.JuT = LayoutInflater.from(getContext()).inflate(2131495278, this, false);
    }
    return this.JuT;
  }
  
  public View getTextEditView()
  {
    if (this.JuS == null)
    {
      this.JuS = LayoutInflater.from(getContext()).inflate(2131493741, null);
      this.JuU = ((PhotoEditText)this.JuS.findViewById(2131305727));
      int k = (int)this.JuU.getResources().getDimension(2131166167);
      int j = (int)this.JuU.getResources().getDimension(2131166048);
      int i = j;
      if (aj.aG(getContext())) {
        i = j + aj.aF(getContext());
      }
      this.JuU.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.JuS.findViewById(2131304505);
      this.JuV = ((Switch)this.JuS.findViewById(2131297210));
      this.JuV.setTag(Integer.valueOf(-707825));
      this.JuV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.JuU.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void adu(int paramAnonymousInt)
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
    return this.JuS;
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
      this.JuU.postDelayed(new Runnable()
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
            i = a.this.getBottom() - com.tencent.mm.compatible.util.i.YM() - (int)a.this.getResources().getDimension(2131166048);
            ac.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
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
    if (this.cGL == paramBoolean)
    {
      ac.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.cGL = paramBoolean;
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
    if ((this.HUG != paramBoolean) && (getConfig().cGL))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.HUG = paramBoolean;
    }
  }
  
  public void setup(y.a parama)
  {
    this.cGH = parama;
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
    parama.bottomMargin += ap.ej(getContext());
    parama.bottomMargin += com.tencent.mm.cc.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, aa.bi(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += ap.ej(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131165251)).gravity = 48;
    if (this.cGH.cGL)
    {
      addView(getActionBar());
      return;
    }
    getBaseFooterView().setVisibility(8);
  }
  
  public final void yq(boolean paramBoolean)
  {
    ac.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.utS.getVisibility() == 0) && (paramBoolean))
    {
      this.utS.setVisibility(8);
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
      this.utS.startAnimation(localAnimation);
    }
    while ((this.utS.getVisibility() != 8) || (paramBoolean)) {
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
    this.utS.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */