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
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.api.ae;
import com.tencent.mm.api.f;
import com.tencent.mm.api.i;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.bo.a.a;
import com.tencent.mm.bo.a.c;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.bo.a.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends f
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Button Lev;
  private boolean aesq = true;
  protected i[] agFV;
  private View agFW;
  private com.tencent.mm.view.footer.a agFX;
  private View agFY;
  private View agFZ;
  private PhotoEditText agGa;
  private Switch agGb;
  private com.tencent.mm.view.b.a hcn;
  private ac.a hdX;
  public boolean heb = true;
  private com.tencent.mm.bt.b hoR;
  private ChatFooterPanel uKY;
  private View ugI;
  private Button zVS;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void NY(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.uKY.getVisibility() == 0) && (paramBoolean))
    {
      this.uKY.setVisibility(8);
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.push_down_out);
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
      this.uKY.startAnimation(localAnimation);
    }
    while ((this.uKY.getVisibility() != 8) || (paramBoolean)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.push_up_in);
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
    this.uKY.startAnimation(localAnimation);
  }
  
  public View getActionBar()
  {
    if (this.ugI == null)
    {
      this.ugI = LayoutInflater.from(getContext()).inflate(a.f.photoedit_actionbar_view, null);
      if (!aw.bx(getContext())) {
        break label125;
      }
    }
    label125:
    for (int i = aw.bw(getContext()) + 0;; i = 0)
    {
      this.ugI.setPadding(0, i, 0, 0);
      this.Lev = ((Button)this.ugI.findViewById(a.e.edit_text_ok));
      this.Lev.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9348);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
      this.zVS = ((Button)this.ugI.findViewById(a.e.edit_text_cancel));
      this.zVS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (a.this.getTextEditView().getVisibility() == 0) {
            a.this.getPresenter().iPn();
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
      return this.ugI;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.hcn == null) {
      this.hcn = jMg();
    }
    return this.hcn;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.agFX == null) {
      this.agFX = jMh();
    }
    return this.agFX;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.uKY == null) {}
    try
    {
      this.uKY = ae.co(getContext());
      this.uKY.setEntranceScene(ChatFooterPanel.XYn);
      this.uKY.setShowSmiley(false);
      this.uKY.setShowClose(true);
      this.uKY.setVisibility(8);
      this.uKY.onResume();
      ad localad = ae.aBJ();
      localad.hej = new ad.a()
      {
        public final void a(t paramAnonymoust)
        {
          AppMethodBeat.i(9357);
          Log.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramAnonymoust });
          a.this.getPresenter().d(paramAnonymoust);
          onHide();
          AppMethodBeat.o(9357);
        }
        
        public final void onHide()
        {
          AppMethodBeat.i(9358);
          a.this.setActionBarVisible(true);
          a.this.NY(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.uKY.setCallback(localad);
      return this.uKY;
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
  
  public ac.a getConfig()
  {
    return this.hdX;
  }
  
  public abstract i[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.agFW == null)
    {
      this.agFW = LayoutInflater.from(getContext()).inflate(a.f.footer_bg_view, null);
      this.agFW.setVisibility(8);
    }
    return this.agFW;
  }
  
  public com.tencent.mm.bt.b getPresenter()
  {
    if (this.hoR == null)
    {
      this.hoR = new com.tencent.mm.bt.a();
      this.hoR.a(this);
    }
    return this.hoR;
  }
  
  public View getRubbishView()
  {
    if (this.agFY == null) {
      this.agFZ = LayoutInflater.from(getContext()).inflate(a.f.rubbish_view, this, false);
    }
    return this.agFZ;
  }
  
  public View getTextEditView()
  {
    if (this.agFY == null)
    {
      this.agFY = LayoutInflater.from(getContext()).inflate(a.f.edit_text_view, null);
      this.agGa = ((PhotoEditText)this.agFY.findViewById(a.e.text_edit));
      int k = (int)this.agGa.getResources().getDimension(a.c.edit_text_padding);
      int j = (int)this.agGa.getResources().getDimension(a.c.color_select_layout_height);
      int i = j;
      if (aw.bx(getContext())) {
        i = j + aw.bw(getContext());
      }
      this.agGa.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.agFY.findViewById(a.e.select_color_bar);
      this.agGb = ((Switch)this.agFY.findViewById(a.e.bg_switch));
      this.agGb.setTag(Integer.valueOf(-707825));
      this.agGb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.agGa.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void apC(int paramAnonymousInt)
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
    return this.agFY;
  }
  
  protected abstract com.tencent.mm.view.b.a jMg();
  
  protected abstract com.tencent.mm.view.footer.a jMh();
  
  public final boolean jMi()
  {
    return (this.uKY.getVisibility() == 0) || (getTextEditView().getVisibility() == 0);
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
      this.agGa.postDelayed(new Runnable()
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
              break label145;
            }
            i = a.this.getBottom() - (int)a.this.getResources().getDimension(a.c.color_select_layout_height);
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
            label145:
            i = a.this.getBottom() - j.aQk() - (int)a.this.getResources().getDimension(a.c.color_select_layout_height);
            Log.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
          }
        }
      }, 160L);
    }
  }
  
  public void setActionBarCallback(k paramk)
  {
    getPresenter().setActionBarCallback(paramk);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.heb == paramBoolean)
    {
      Log.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.heb = paramBoolean;
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_in);
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
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_out);
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
      localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_in);
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
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.alpha_out);
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
    if ((this.aesq != paramBoolean) && (getConfig().heb))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.aesq = paramBoolean;
    }
  }
  
  public void setup(ac.a parama)
  {
    this.hdX = parama;
    getPresenter().a(getConfig());
    removeAllViews();
    parama = new FrameLayout.LayoutParams(-1, -1);
    addView(getBaseBoardView(), parama);
    parama = new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(a.c.feature_select_all_layout_height));
    parama.gravity = 80;
    addView(getFooterBg(), parama);
    addView(getBaseFooterView(), parama);
    parama = new FrameLayout.LayoutParams(-1, -1);
    getTextEditView().setVisibility(8);
    addView(getTextEditView(), parama);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    parama = (FrameLayout.LayoutParams)getRubbishView().getLayoutParams();
    parama.gravity = 81;
    parama.bottomMargin += bf.bk(getContext());
    parama.bottomMargin += com.tencent.mm.cd.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, ae.cp(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += bf.bk(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(a.c.DefaultActionbarHeightLand)).gravity = 48;
    if (this.hdX.heb) {
      addView(getActionBar());
    }
    for (;;)
    {
      this.hcn.reset();
      return;
      getBaseFooterView().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */