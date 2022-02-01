package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;

public class CollapseView
  extends LinearLayout
{
  ImageView HAo;
  public TextView JQB;
  private RelativeLayout Ltd;
  private RelativeLayout Lte;
  RelativeLayout Ltf;
  public ImageView Ltg;
  private View Lth;
  private View Lti;
  private float Ltj;
  private String Ltk;
  ImageButton Ltl;
  private boolean Ltm;
  private boolean Ltn;
  private boolean Lto;
  private float Ltp;
  private boolean Ltq;
  long duration;
  private float hpy;
  private Context mContext;
  private boolean wJw;
  
  public CollapseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178913);
    this.duration = 200L;
    this.Ltj = 0.7F;
    this.wJw = false;
    this.Ltm = false;
    this.Ltn = false;
    this.Lto = false;
    this.Ltp = 0.0F;
    this.Ltq = true;
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext).inflate(a.f.multitalk_general_control, this);
    this.JQB = ((TextView)findViewById(a.e.voip_net_status_hint));
    this.Ltg = ((ImageView)findViewById(a.e.link_arrow));
    this.Ltg.setImageDrawable(bb.m(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
    this.Ltf = ((RelativeLayout)findViewById(a.e.contentRelativeLayout));
    this.Lte = ((RelativeLayout)findViewById(a.e.hangup_icon_layout));
    this.HAo = ((ImageView)findViewById(a.e.more_arrow));
    this.HAo.setBackground(bb.m(paramContext, a.g.icons_filled_arrow, -1));
    this.Ltd = ((RelativeLayout)findViewById(a.e.more_click));
    paramContext = this.Ltd;
    int i = f.Lue;
    paramAttributeSet = (View)paramContext.getParent();
    paramAttributeSet.post(new CollapseView.2(paramContext, i, paramAttributeSet));
    this.Ltd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178905);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (CollapseView.a(CollapseView.this))
        {
          if (ac.ggS().ggg().geG()) {
            o.Loa += 1;
          }
          CollapseView.a(CollapseView.this, false);
          CollapseView.this.ghq();
          CollapseView.b(CollapseView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178905);
      }
    });
    this.HAo.setRotation(270.0F);
    this.Ltf.setVisibility(4);
    AppMethodBeat.o(178913);
  }
  
  private void ai(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178915);
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      float f;
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(178915);
              return;
            } while (this.Ltm);
            this.hpy = paramMotionEvent.getRawY();
            AppMethodBeat.o(178915);
            return;
            f = paramMotionEvent.getRawY() - this.hpy;
          } while ((!this.Ltm) && (Math.abs(f) < 5.0F));
          this.hpy = paramMotionEvent.getRawY();
        } while (Math.abs(f) <= 1.0F);
        y(this.Ltf, -f);
        jdMethod_if(this.Ltl);
        ghr();
        if (f > 0.0F)
        {
          this.Ltm = true;
          this.Lto = true;
          this.Ltn = false;
          AppMethodBeat.o(178915);
          return;
        }
      } while (f >= 0.0F);
      this.Ltm = true;
      this.Ltn = true;
      this.Lto = false;
      AppMethodBeat.o(178915);
      return;
    }
    if ((this.Ltp > this.Ltj) && (this.Ltp < 1.0F)) {
      this.Ltn = true;
    }
    label401:
    for (;;)
    {
      boolean bool = false;
      label211:
      this.Lto = bool;
      label216:
      if ((this.Ltn) && (this.Ltm))
      {
        this.Ltn = false;
        this.wJw = true;
        y(this.Ltf, 9999.0F);
        jdMethod_if(this.Ltl);
        ghr();
      }
      for (;;)
      {
        this.Ltm = false;
        break;
        if ((this.Ltp < 1.0F - this.Ltj) && (this.Ltp > 0.0F))
        {
          this.Ltn = false;
          bool = true;
          break label211;
        }
        if ((this.Ltp == 0.0F) || (this.Ltp == 1.0F)) {
          break label216;
        }
        if (!this.Ltn) {}
        for (bool = true;; bool = false)
        {
          this.Ltn = bool;
          if (this.Lto) {
            break label401;
          }
          bool = true;
          break;
        }
        if ((this.Lto) && (this.Ltm))
        {
          this.Lto = false;
          this.wJw = false;
          y(this.Ltf, -9999.0F);
          jdMethod_if(this.Ltl);
          ghr();
        }
      }
    }
  }
  
  private void expand(final View paramView)
  {
    AppMethodBeat.i(285995);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(aw.bf(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    paramView.setVisibility(0);
    if (this.Lth != null) {
      this.Lth.setVisibility(4);
    }
    Animation local6 = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f = 1.0F;
        AppMethodBeat.i(178911);
        if (paramAnonymousFloat == 1.0F)
        {
          CollapseView.i(CollapseView.this).setVisibility(0);
          paramView.getLayoutParams().height = i;
          CollapseView.b(CollapseView.this, true);
          paramView.requestLayout();
          AppMethodBeat.o(178911);
          return;
        }
        if (paramAnonymousFloat >= CollapseView.j(CollapseView.this))
        {
          CollapseView.i(CollapseView.this).setVisibility(0);
          paramAnonymousTransformation = CollapseView.i(CollapseView.this);
          if ((paramAnonymousFloat - CollapseView.j(CollapseView.this) + 0.1F) * 2.5D < 1.0D) {
            break label179;
          }
        }
        for (;;)
        {
          paramAnonymousTransformation.setAlpha(f);
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.Lud * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.LtV * paramAnonymousFloat));
          paramView.getLayoutParams().height = ((int)(i * paramAnonymousFloat));
          break;
          label179:
          f = (paramAnonymousFloat - CollapseView.j(CollapseView.this) + 0.1F) * 2.5F;
        }
      }
      
      public final boolean willChangeBounds()
      {
        return true;
      }
    };
    local6.setDuration(this.duration);
    paramView.startAnimation(local6);
    AppMethodBeat.o(285995);
  }
  
  private void ghp()
  {
    AppMethodBeat.i(285986);
    if (this.Ltl != null)
    {
      if ((this.Ltl.getTag() == null) || (this.Ltl.getTag().equals(Boolean.TRUE)))
      {
        this.Ltl.setTag(Boolean.FALSE);
        final ImageButton localImageButton = this.Ltl;
        int i = f.Lui;
        localImageButton.measure(i, i);
        Animation local4 = new Animation()
        {
          protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            int j = -2;
            AppMethodBeat.i(178909);
            paramAnonymousTransformation = CollapseView.this;
            boolean bool;
            if (paramAnonymousFloat == 1.0F)
            {
              bool = true;
              CollapseView.a(paramAnonymousTransformation, bool);
              paramAnonymousTransformation = localImageButton.getLayoutParams();
              if (paramAnonymousFloat != 1.0F) {
                break label141;
              }
              i = -2;
              label47:
              paramAnonymousTransformation.height = i;
              paramAnonymousTransformation = localImageButton.getLayoutParams();
              if (paramAnonymousFloat != 1.0F) {
                break label157;
              }
              i = j;
              label69:
              paramAnonymousTransformation.width = i;
              paramAnonymousTransformation = (RelativeLayout.LayoutParams)localImageButton.getLayoutParams();
              if (paramAnonymousFloat != 1.0F) {
                break label173;
              }
            }
            label141:
            label157:
            label173:
            for (int i = f.Lub;; i = f.Lua + (int)((f.Lub - f.Lua) * paramAnonymousFloat))
            {
              paramAnonymousTransformation.bottomMargin = i;
              ((RelativeLayout.LayoutParams)localImageButton.getLayoutParams()).topMargin = ((int)(f.Lua * (1.0F - paramAnonymousFloat)));
              localImageButton.requestLayout();
              AppMethodBeat.o(178909);
              return;
              bool = false;
              break;
              i = f.Lue + (int)(this.KsF * paramAnonymousFloat);
              break label47;
              i = f.Lue + (int)(this.KsF * paramAnonymousFloat);
              break label69;
            }
          }
          
          public final boolean willChangeBounds()
          {
            return true;
          }
        };
        local4.setDuration(this.duration);
        localImageButton.startAnimation(local4);
        AppMethodBeat.o(285986);
        return;
      }
      this.Ltl.setTag(Boolean.TRUE);
      ie(this.Ltl);
    }
    AppMethodBeat.o(285986);
  }
  
  private void ghr()
  {
    AppMethodBeat.i(178918);
    int i = (int)(270.0F + this.Ltp * 180.0F);
    this.HAo.setRotation(i);
    ImageView localImageView = this.HAo;
    if (this.Ltp == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localImageView.setTag(Boolean.valueOf(bool));
      this.HAo.requestLayout();
      AppMethodBeat.o(178918);
      return;
    }
  }
  
  private void jdMethod_if(View paramView)
  {
    AppMethodBeat.i(178920);
    int i = f.Lui;
    int j = f.Lue;
    i = f.Lue + (int)((i - j) * this.Ltp);
    paramView.getLayoutParams().height = i;
    paramView.getLayoutParams().width = i;
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = (f.Lua + (int)((f.Lub - f.Lua) * this.Ltp));
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.Lua * (1.0F - this.Ltp)));
    paramView.requestLayout();
    paramView = this.Ltl;
    if (i != f.Lui) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(Boolean.valueOf(bool));
      AppMethodBeat.o(178920);
      return;
    }
  }
  
  private void y(View paramView, float paramFloat)
  {
    AppMethodBeat.i(178919);
    paramView.setVisibility(0);
    if (this.Lth != null) {
      this.Lth.setVisibility(4);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(aw.bf(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    int i = paramView.getMeasuredHeight();
    float f = paramView.getLayoutParams().height + paramFloat;
    View localView;
    if (f >= i)
    {
      paramFloat = i;
      this.Ltp = (paramFloat / i);
      if (this.Ltp >= this.Ltj)
      {
        this.Lth.setVisibility(0);
        localView = this.Lth;
        if ((this.Ltp - this.Ltj + 0.1D) * 2.5D < 1.0D) {
          break label229;
        }
      }
    }
    label229:
    for (f = 1.0F;; f = (this.Ltp - this.Ltj + 0.1F) * 2.5F)
    {
      localView.setAlpha(f);
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(this.Ltp * f.Lud));
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(this.Ltp * f.LtV));
      paramView.getLayoutParams().height = ((int)paramFloat);
      paramView.requestLayout();
      AppMethodBeat.o(178919);
      return;
      paramFloat = f;
      if (f > 0.0F) {
        break;
      }
      paramView.setVisibility(8);
      paramFloat = 0.0F;
      break;
    }
  }
  
  public final void aI(View paramView, int paramInt)
  {
    AppMethodBeat.i(178916);
    Log.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", new Object[] { Boolean.TRUE, paramView, Integer.valueOf(paramInt) });
    if (this.Lth != null)
    {
      Log.i("MicroMsg.CollapseView", "setContent already have content layout");
      AppMethodBeat.o(178916);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.Lth = paramView;
    paramView = new LinearLayout.LayoutParams(-1, -2);
    paramView.gravity = 17;
    this.Ltf.addView(this.Lth, paramView);
    this.Ltf.setVisibility(0);
    this.Ltf.setVisibility(0);
    setAlpha(0.0F);
    this.Ltd.setAlpha(0.0F);
    animate().alpha(1.0F).setDuration(500L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(178908);
        CollapseView.i(CollapseView.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(178907);
            CollapseView.c(CollapseView.this).setTag(Boolean.TRUE);
            CollapseView.d(CollapseView.this).setTag(Boolean.FALSE);
            CollapseView.a(CollapseView.this, CollapseView.e(CollapseView.this));
            CollapseView.f(CollapseView.this).setAlpha(0.0F);
            CollapseView.f(CollapseView.this).animate().alpha(1.0F).setDuration(CollapseView.g(CollapseView.this)).start();
            CollapseView.b(CollapseView.this);
            if ((CollapseView.h(CollapseView.this) != null) && (!ac.ggS().Loo))
            {
              o.t(1, CollapseView.h(CollapseView.this), 2);
              ac.ggS().Loo = true;
            }
            AppMethodBeat.o(178907);
          }
        });
        AppMethodBeat.o(178908);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(178916);
  }
  
  public final void abQ(int paramInt)
  {
    AppMethodBeat.i(286154);
    if (this.Ltl != null) {
      this.Ltl.setRotation(360 - paramInt);
    }
    AppMethodBeat.o(286154);
  }
  
  public final void exz()
  {
    AppMethodBeat.i(286123);
    if ((this.Ltl.getTag() == null) || (this.Ltl.getTag().equals(Boolean.TRUE))) {
      ghp();
    }
    if ((this.HAo.getTag() == null) || (this.HAo.getTag().equals(Boolean.TRUE))) {
      ghq();
    }
    AppMethodBeat.o(286123);
  }
  
  public final void ghq()
  {
    AppMethodBeat.i(286131);
    int i;
    if ((this.HAo.getTag() == null) || (this.HAo.getTag().equals(Boolean.TRUE)))
    {
      this.HAo.setTag(Boolean.FALSE);
      i = 90;
      expand(this.Ltf);
      if (this.Ltk != null) {
        o.t(2, this.Ltk, 1);
      }
      o.yV(true);
    }
    for (;;)
    {
      this.HAo.animate().setDuration(this.duration).rotation(i);
      AppMethodBeat.o(286131);
      return;
      i = 270;
      this.HAo.setTag(Boolean.TRUE);
      ig(this.Ltf);
      if (this.Ltk != null) {
        o.t(2, this.Ltk, 2);
      }
      o.yV(false);
    }
  }
  
  public final void id(View paramView)
  {
    AppMethodBeat.i(178917);
    Log.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", new Object[] { Boolean.TRUE, paramView });
    if (this.Lti != null)
    {
      Log.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
      AppMethodBeat.o(178917);
      return;
    }
    if ((ViewGroup)paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.Lti = paramView;
    this.Lte.addView(paramView);
    this.Ltl = ((ImageButton)paramView.findViewById(a.e.talking_hangup_btn));
    paramView = (RelativeLayout.LayoutParams)this.Ltl.getLayoutParams();
    paramView.width = f.Lui;
    paramView.height = f.Lui;
    paramView.bottomMargin = f.Lub;
    this.Ltl.setLayoutParams(paramView);
    AppMethodBeat.o(178917);
  }
  
  public final void ie(final View paramView)
  {
    AppMethodBeat.i(286115);
    Animation local5 = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(178910);
        paramAnonymousTransformation = CollapseView.this;
        if (paramAnonymousFloat == 1.0F) {}
        for (boolean bool = true;; bool = false)
        {
          CollapseView.a(paramAnonymousTransformation, bool);
          if (paramView.getLayoutParams().height != f.Lue) {
            break;
          }
          AppMethodBeat.o(178910);
          return;
        }
        if (paramAnonymousFloat != 1.0F)
        {
          paramView.getLayoutParams().height = (f.Lui - (int)(this.Ltu * paramAnonymousFloat));
          paramView.getLayoutParams().width = (f.Lui - (int)(this.Ltu * paramAnonymousFloat));
          paramAnonymousTransformation = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          int i = f.Lub;
          paramAnonymousTransformation.bottomMargin = (i - (int)((i - f.Lua) * paramAnonymousFloat));
          ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.Lua * paramAnonymousFloat));
          paramView.requestLayout();
        }
        AppMethodBeat.o(178910);
      }
      
      public final boolean willChangeBounds()
      {
        return true;
      }
    };
    local5.setDuration(this.duration);
    paramView.startAnimation(local5);
    AppMethodBeat.o(286115);
  }
  
  final void ig(final View paramView)
  {
    AppMethodBeat.i(178921);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(aw.bf(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    if (this.Lth != null) {
      this.Lth.setVisibility(0);
    }
    Animation local7 = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        float f = 1.0F;
        AppMethodBeat.i(178912);
        if (paramAnonymousFloat == 1.0F)
        {
          paramView.setVisibility(8);
          CollapseView.b(CollapseView.this, false);
          paramView.requestLayout();
          AppMethodBeat.o(178912);
          return;
        }
        if ((paramAnonymousFloat >= CollapseView.j(CollapseView.this)) && (CollapseView.i(CollapseView.this) != null)) {
          CollapseView.i(CollapseView.this).setVisibility(4);
        }
        if (CollapseView.i(CollapseView.this) != null) {
          if ((1.0F - paramAnonymousFloat) * 2.5D < 1.0D) {
            break label177;
          }
        }
        for (;;)
        {
          CollapseView.i(CollapseView.this).setAlpha(f);
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.Lud * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.LtV * paramAnonymousFloat));
          paramView.getLayoutParams().height = (i - (int)(i * paramAnonymousFloat));
          break;
          label177:
          f = (1.0F - paramAnonymousFloat) * 2.5F;
        }
      }
      
      public final boolean willChangeBounds()
      {
        return true;
      }
    };
    local7.setDuration(this.duration);
    paramView.startAnimation(local7);
    AppMethodBeat.o(178921);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178914);
    ai(paramMotionEvent);
    AppMethodBeat.o(178914);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178922);
    Log.d("MicroMsg.CollapseView", "event: " + paramMotionEvent.getAction());
    ai(paramMotionEvent);
    AppMethodBeat.o(178922);
    return true;
  }
  
  public void setLinkToAutoMobileListener(final a parama)
  {
    AppMethodBeat.i(286157);
    if (findViewById(a.e.net_tip_layout) != null) {
      findViewById(a.e.net_tip_layout).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(285452);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (CollapseView.this.findViewById(a.e.net_tip_layout) != null) {
            parama.onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(285452);
        }
      });
    }
    AppMethodBeat.o(286157);
  }
  
  public void setRoomKey(String paramString)
  {
    this.Ltk = paramString;
  }
  
  static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView
 * JD-Core Version:    0.7.0.1
 */