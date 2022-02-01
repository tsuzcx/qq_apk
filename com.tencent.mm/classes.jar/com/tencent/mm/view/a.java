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
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.bv.a.a;
import com.tencent.mm.bv.a.c;
import com.tencent.mm.bv.a.e;
import com.tencent.mm.bv.a.f;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.view.footer.SelectColorBar.a;

public abstract class a
  extends e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Button FiX;
  private boolean WKm = true;
  protected h[] YKd;
  private View YKe;
  private com.tencent.mm.view.footer.a YKf;
  private View YKg;
  private View YKh;
  private PhotoEditText YKi;
  private Switch YKj;
  private com.tencent.mm.view.b.a eYN;
  public boolean faA = true;
  private ab.a faw;
  private com.tencent.mm.ca.b fkE;
  private View raR;
  private ChatFooterPanel rzI;
  private Button wzH;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Ic(boolean paramBoolean)
  {
    Log.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.rzI.getVisibility() == 0) && (paramBoolean))
    {
      this.rzI.setVisibility(8);
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
      this.rzI.startAnimation(localAnimation);
    }
    while ((this.rzI.getVisibility() != 8) || (paramBoolean)) {
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
    this.rzI.startAnimation(localAnimation);
  }
  
  public View getActionBar()
  {
    if (this.raR == null)
    {
      this.raR = LayoutInflater.from(getContext()).inflate(a.f.photoedit_actionbar_view, null);
      if (!ar.aN(getContext())) {
        break label125;
      }
    }
    label125:
    for (int i = ar.aM(getContext()) + 0;; i = 0)
    {
      this.raR.setPadding(0, i, 0, 0);
      this.FiX = ((Button)this.raR.findViewById(a.e.edit_text_ok));
      this.FiX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9348);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/BaseDrawingView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
      this.wzH = ((Button)this.raR.findViewById(a.e.edit_text_cancel));
      this.wzH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(9354);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/BaseDrawingView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (a.this.getTextEditView().getVisibility() == 0) {
            a.this.getPresenter().hot();
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
      return this.raR;
    }
  }
  
  public <T extends com.tencent.mm.view.b.a> T getBaseBoardView()
  {
    if (this.eYN == null) {
      this.eYN = igR();
    }
    return this.eYN;
  }
  
  public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView()
  {
    if (this.YKf == null) {
      this.YKf = igS();
    }
    return this.YKf;
  }
  
  public ChatFooterPanel getChatFooterPanel()
  {
    boolean bool = false;
    if (this.rzI == null) {}
    try
    {
      this.rzI = ad.bB(getContext());
      this.rzI.setEntranceScene(ChatFooterPanel.Rci);
      this.rzI.setShowSmiley(false);
      this.rzI.setShowClose(true);
      this.rzI.setVisibility(8);
      this.rzI.onResume();
      ac localac = ad.aaf();
      localac.faJ = new ac.a()
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
          a.this.Ic(true);
          a.this.setFooterVisible(true);
          AppMethodBeat.o(9358);
        }
      };
      this.rzI.setCallback(localac);
      return this.rzI;
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
    return this.faw;
  }
  
  public abstract h[] getFeatures();
  
  public View getFooterBg()
  {
    if (this.YKe == null)
    {
      this.YKe = LayoutInflater.from(getContext()).inflate(a.f.footer_bg_view, null);
      this.YKe.setVisibility(8);
    }
    return this.YKe;
  }
  
  public com.tencent.mm.ca.b getPresenter()
  {
    if (this.fkE == null)
    {
      this.fkE = new com.tencent.mm.ca.a();
      this.fkE.a(this);
    }
    return this.fkE;
  }
  
  public View getRubbishView()
  {
    if (this.YKg == null) {
      this.YKh = LayoutInflater.from(getContext()).inflate(a.f.rubbish_view, this, false);
    }
    return this.YKh;
  }
  
  public View getTextEditView()
  {
    if (this.YKg == null)
    {
      this.YKg = LayoutInflater.from(getContext()).inflate(a.f.edit_text_view, null);
      this.YKi = ((PhotoEditText)this.YKg.findViewById(a.e.text_edit));
      int k = (int)this.YKi.getResources().getDimension(a.c.edit_text_padding);
      int j = (int)this.YKi.getResources().getDimension(a.c.color_select_layout_height);
      int i = j;
      if (ar.aN(getContext())) {
        i = j + ar.aM(getContext());
      }
      this.YKi.setPadding(k, i, k, 0);
      final SelectColorBar localSelectColorBar = (SelectColorBar)this.YKg.findViewById(a.e.select_color_bar);
      this.YKj = ((Switch)this.YKg.findViewById(a.e.bg_switch));
      this.YKj.setTag(Integer.valueOf(-707825));
      this.YKj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.YKi.setTextColor(-1);
      localSelectColorBar.setSelectColor(-1);
      localSelectColorBar.setSelectColorListener(new SelectColorBar.a()
      {
        public final void akj(int paramAnonymousInt)
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
    return this.YKg;
  }
  
  protected abstract com.tencent.mm.view.b.a igR();
  
  protected abstract com.tencent.mm.view.footer.a igS();
  
  public final boolean igT()
  {
    return (this.rzI.getVisibility() == 0) || (getTextEditView().getVisibility() == 0);
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
      this.YKi.postDelayed(new Runnable()
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
            i = a.this.getBottom() - i.avM() - (int)a.this.getResources().getDimension(a.c.color_select_layout_height);
            Log.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", new Object[] { Integer.valueOf(i) });
          }
        }
      }, 160L);
    }
  }
  
  public void setActionBarCallback(j paramj)
  {
    getPresenter().setActionBarCallback(paramj);
  }
  
  public void setActionBarVisible(boolean paramBoolean)
  {
    if (this.faA == paramBoolean)
    {
      Log.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
      return;
    }
    this.faA = paramBoolean;
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
    if ((this.WKm != paramBoolean) && (getConfig().faA))
    {
      getBaseFooterView().setFooterVisible(paramBoolean);
      setFooterBgVisible(paramBoolean);
      this.WKm = paramBoolean;
    }
  }
  
  public void setup(ab.a parama)
  {
    this.faw = parama;
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
    parama.bottomMargin += ax.aB(getContext());
    parama.bottomMargin += com.tencent.mm.ci.a.fromDPToPix(getContext(), 32);
    getRubbishView().setVisibility(8);
    addView(getRubbishView(), parama);
    parama = new FrameLayout.LayoutParams(-1, ad.bC(getContext()));
    parama.gravity = 80;
    parama.bottomMargin += ax.aB(getContext());
    addView(getChatFooterPanel(), parama);
    new FrameLayout.LayoutParams(-1, (int)getResources().getDimension(a.c.DefaultActionbarHeightLand)).gravity = 48;
    if (this.faw.faA)
    {
      addView(getActionBar());
      return;
    }
    getBaseFooterView().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.a
 * JD-Core Version:    0.7.0.1
 */