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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean Kea = true;
  protected g[] LKC;
  private View LKD;
  private com.tencent.mm.view.footer.a LKE;
  private View LKF;
  private View LKG;
  private PhotoEditText LKH;
  private Switch LKI;
  private com.tencent.mm.view.b.a cQM;
  private y.a cSv;
  public boolean cSz = true;
  private com.tencent.mm.bt.b dbm;
  private View mLY;
  private Button rti;
  public ChatFooterPanel vIz;
  private Button wjz;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract com.tencent.mm.view.b.a fUg();
  
  protected abstract com.tencent.mm.view.footer.a fUh();
  
  public View getActionBar()
  {
    if (this.mLY == null)
    {
      this.mLY = LayoutInflater.from(getContext()).inflate(2131495089, null);
      if (!al.aH(getContext())) {
        break label122;
      }
    }
    label122:
    for (int i = al.aG(getContext()) + 0;; i = 0)
    {
      this.mLY.setPadding(0, i, 0, 0);
      this.wjz = ((Button)this.mLY.findViewById(2131299265));
      this.wjz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9348);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
      this.rti = ((Button)this.mLY.findViewById(2131299263));
      this.rti.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (a.this.getTextEditView().getVisibility() == 0) {
            a.this.getPresenter().fjG();
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
      return this.mLY;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.cQM == null) {
      this.cQM = fUg();
    }
    return this.cQM;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.LKE == null) {
      this.LKE = fUh();
    }
    return this.LKE;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.vIz == null) {}
    try
    {
      this.vIz = aa.bi(getContext());
      this.vIz.setEntranceScene(ChatFooterPanel.FkL);
      this.vIz.setShowSmiley(false);
      this.vIz.setShowClose(true);
      this.vIz.setVisibility(8);
      this.vIz.onResume();
      z localz = aa.Lw();
      localz.cSG = new z.a()
      {
        public final void a(p paramAnonymousp)
        {
          AppMethodBeat.i(9357);
          ae.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymousp });
          a.this.getPresenter().c(paramAnonymousp);
          onHide();
          AppMethodBeat.o(9357);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(9358);
          a.this.setActionBarVisible(true);
          a.this.zr(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.vIz.setCallback(localz);
      return this.vIz;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (getContext() == null) {
        bool = true;
      }
      ae.e("MicroMsg.BaseDrawingView", "exception:%s,getContext() is null?", new Object[] { str, Boolean.valueOf(bool) });
      throw localException;
    }
  }
  
  public y.a getConfig()
  {
    return this.cSv;
  }
  
  public abstract g[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.LKD == null)
    {
      this.LKD = LayoutInflater.from(getContext()).inflate(2131494159, null);
      this.LKD.setVisibility(8);
    }
    return this.LKD;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    if (this.dbm == null)
    {
      this.dbm = new com.tencent.mm.bt.a();
      this.dbm.a(this);
    }
    return this.dbm;
  }
  
  public View getRubbishView()
  {
    if (this.LKF == null) {
      this.LKG = LayoutInflater.from(getContext()).inflate(2131495278, this, false);
    }
    return this.LKG;
  }
  
  public View getTextEditView()
  {
    if (this.LKF == null)
    {
      this.LKF = LayoutInflater.from(getContext()).inflate(2131493741, null);
      this.LKH = ((PhotoEditText)this.LKF.findViewById(2131305727));
      int k = (int)this.LKH.getResources().getDimension(2131166167);
      int j = (int)this.LKH.getResources().getDimension(2131166048);
      int i = j;
      if (al.aH(getContext())) {
        i = j + al.aG(getContext());
      }
      this.LKH.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.LKF.findViewById(2131304505);
      this.LKI = ((Switch)this.LKF.findViewById(2131297210));
      this.LKI.setTag(Integer.valueOf(-707825));
      this.LKI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.LKH.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void Uk(int paramAnonymousInt)
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
    return this.LKF;
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
      this.LKH.postDelayed(new Runnable()
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
            i = a.this.getBottom() - com.tencent.mm.compatible.util.i.abx() - (int)a.this.getResources().getDimension(2131166048);
            ae.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
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
    if (this.cSz == paramBoolean)
    {
      ae.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.cSz = paramBoolean;
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
    if ((this.Kea != paramBoolean) && (getConfig().cSz))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.Kea = paramBoolean;
    }
  }
  
  public void setup(y.a parama)
  {
    this.cSv = parama;
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
    parama.bottomMargin += ar.en(getContext());
    parama.bottomMargin += com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, aa.bj(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += ar.en(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(2131165251)).gravity = 48;
    if (this.cSv.cSz)
    {
      addView(getActionBar());
      return;
    }
    getBaseFooterView().setVisibility(8);
  }
  
  public final void zr(boolean paramBoolean)
  {
    ae.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.vIz.getVisibility() == 0) && (paramBoolean))
    {
      this.vIz.setVisibility(8);
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
      this.vIz.startAnimation(localAnimation);
    }
    while ((this.vIz.getVisibility() != 8) || (paramBoolean)) {
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
    this.vIz.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */