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
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;

public class CollapseView
  extends LinearLayout
{
  ImageView BOy;
  public TextView DZt;
  private RelativeLayout FwT;
  private RelativeLayout FwU;
  RelativeLayout FwV;
  public ImageView FwW;
  private View FwX;
  private View FwY;
  private float FwZ;
  private String Fxa;
  ImageButton Fxb;
  private boolean Fxc;
  private boolean Fxd;
  private boolean Fxe;
  private float Fxf;
  private boolean Fxg;
  long duration;
  private float fll;
  private Context mContext;
  private boolean tFX;
  
  public CollapseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178913);
    this.duration = 200L;
    this.FwZ = 0.7F;
    this.tFX = false;
    this.Fxc = false;
    this.Fxd = false;
    this.Fxe = false;
    this.Fxf = 0.0F;
    this.Fxg = true;
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext).inflate(a.f.multitalk_general_control, this);
    this.DZt = ((TextView)findViewById(a.e.voip_net_status_hint));
    this.FwW = ((ImageView)findViewById(a.e.link_arrow));
    this.FwW.setImageDrawable(au.o(MMApplicationContext.getContext(), a.g.icons_filled_arrow, -1));
    this.FwV = ((RelativeLayout)findViewById(a.e.contentRelativeLayout));
    this.FwU = ((RelativeLayout)findViewById(a.e.hangup_icon_layout));
    this.BOy = ((ImageView)findViewById(a.e.more_arrow));
    this.BOy.setBackground(au.o(paramContext, a.g.icons_filled_arrow, -1));
    this.FwT = ((RelativeLayout)findViewById(a.e.more_click));
    paramContext = this.FwT;
    int i = f.FxS;
    paramAttributeSet = (View)paramContext.getParent();
    paramAttributeSet.post(new CollapseView.2(paramContext, i, paramAttributeSet));
    this.FwT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178905);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (CollapseView.a(CollapseView.this))
        {
          if (ad.eYc().eXq().eVP()) {
            p.FrN += 1;
          }
          CollapseView.a(CollapseView.this, false);
          CollapseView.this.eYv();
          CollapseView.b(CollapseView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178905);
      }
    });
    this.BOy.setRotation(270.0F);
    this.FwV.setVisibility(4);
    AppMethodBeat.o(178913);
  }
  
  private void C(MotionEvent paramMotionEvent)
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
            } while (this.Fxc);
            this.fll = paramMotionEvent.getRawY();
            AppMethodBeat.o(178915);
            return;
            f = paramMotionEvent.getRawY() - this.fll;
          } while ((!this.Fxc) && (Math.abs(f) < 5.0F));
          this.fll = paramMotionEvent.getRawY();
        } while (Math.abs(f) <= 1.0F);
        x(this.FwV, -f);
        ft(this.Fxb);
        eYw();
        if (f > 0.0F)
        {
          this.Fxc = true;
          this.Fxe = true;
          this.Fxd = false;
          AppMethodBeat.o(178915);
          return;
        }
      } while (f >= 0.0F);
      this.Fxc = true;
      this.Fxd = true;
      this.Fxe = false;
      AppMethodBeat.o(178915);
      return;
    }
    if ((this.Fxf > this.FwZ) && (this.Fxf < 1.0F)) {
      this.Fxd = true;
    }
    label401:
    for (;;)
    {
      boolean bool = false;
      label211:
      this.Fxe = bool;
      label216:
      if ((this.Fxd) && (this.Fxc))
      {
        this.Fxd = false;
        this.tFX = true;
        x(this.FwV, 9999.0F);
        ft(this.Fxb);
        eYw();
      }
      for (;;)
      {
        this.Fxc = false;
        break;
        if ((this.Fxf < 1.0F - this.FwZ) && (this.Fxf > 0.0F))
        {
          this.Fxd = false;
          bool = true;
          break label211;
        }
        if ((this.Fxf == 0.0F) || (this.Fxf == 1.0F)) {
          break label216;
        }
        if (!this.Fxd) {}
        for (bool = true;; bool = false)
        {
          this.Fxd = bool;
          if (this.Fxe) {
            break label401;
          }
          bool = true;
          break;
        }
        if ((this.Fxe) && (this.Fxc))
        {
          this.Fxe = false;
          this.tFX = false;
          x(this.FwV, -9999.0F);
          ft(this.Fxb);
          eYw();
        }
      }
    }
  }
  
  private void eYu()
  {
    AppMethodBeat.i(197266);
    if (this.Fxb != null)
    {
      if ((this.Fxb.getTag() == null) || (this.Fxb.getTag().equals(Boolean.TRUE)))
      {
        this.Fxb.setTag(Boolean.FALSE);
        final ImageButton localImageButton = this.Fxb;
        int i = f.FxW;
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
            for (int i = f.FxP;; i = f.FxO + (int)((f.FxP - f.FxO) * paramAnonymousFloat))
            {
              paramAnonymousTransformation.bottomMargin = i;
              ((RelativeLayout.LayoutParams)localImageButton.getLayoutParams()).topMargin = ((int)(f.FxO * (1.0F - paramAnonymousFloat)));
              localImageButton.requestLayout();
              AppMethodBeat.o(178909);
              return;
              bool = false;
              break;
              i = f.FxS + (int)(this.EzS * paramAnonymousFloat);
              break label47;
              i = f.FxS + (int)(this.EzS * paramAnonymousFloat);
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
        AppMethodBeat.o(197266);
        return;
      }
      this.Fxb.setTag(Boolean.TRUE);
      fr(this.Fxb);
    }
    AppMethodBeat.o(197266);
  }
  
  private void eYw()
  {
    AppMethodBeat.i(178918);
    int i = (int)(270.0F + this.Fxf * 180.0F);
    this.BOy.setRotation(i);
    ImageView localImageView = this.BOy;
    if (this.Fxf == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localImageView.setTag(Boolean.valueOf(bool));
      this.BOy.requestLayout();
      AppMethodBeat.o(178918);
      return;
    }
  }
  
  private void fs(final View paramView)
  {
    AppMethodBeat.i(197287);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ar.au(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    paramView.setVisibility(0);
    if (this.FwX != null) {
      this.FwX.setVisibility(4);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.FxR * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.FxJ * paramAnonymousFloat));
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
    AppMethodBeat.o(197287);
  }
  
  private void ft(View paramView)
  {
    AppMethodBeat.i(178920);
    int i = f.FxW;
    int j = f.FxS;
    i = f.FxS + (int)((i - j) * this.Fxf);
    paramView.getLayoutParams().height = i;
    paramView.getLayoutParams().width = i;
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = (f.FxO + (int)((f.FxP - f.FxO) * this.Fxf));
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.FxO * (1.0F - this.Fxf)));
    paramView.requestLayout();
    paramView = this.Fxb;
    if (i != f.FxW) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(Boolean.valueOf(bool));
      AppMethodBeat.o(178920);
      return;
    }
  }
  
  private void x(View paramView, float paramFloat)
  {
    AppMethodBeat.i(178919);
    paramView.setVisibility(0);
    if (this.FwX != null) {
      this.FwX.setVisibility(4);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ar.au(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    int i = paramView.getMeasuredHeight();
    float f = paramView.getLayoutParams().height + paramFloat;
    View localView;
    if (f >= i)
    {
      paramFloat = i;
      this.Fxf = (paramFloat / i);
      if (this.Fxf >= this.FwZ)
      {
        this.FwX.setVisibility(0);
        localView = this.FwX;
        if ((this.Fxf - this.FwZ + 0.1D) * 2.5D < 1.0D) {
          break label229;
        }
      }
    }
    label229:
    for (f = 1.0F;; f = (this.Fxf - this.FwZ + 0.1F) * 2.5F)
    {
      localView.setAlpha(f);
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(this.Fxf * f.FxR));
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(this.Fxf * f.FxJ));
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
  
  public final void XG(int paramInt)
  {
    AppMethodBeat.i(197321);
    if (this.Fxb != null) {
      this.Fxb.setRotation(360 - paramInt);
    }
    AppMethodBeat.o(197321);
  }
  
  public final void aq(View paramView, int paramInt)
  {
    AppMethodBeat.i(178916);
    Log.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", new Object[] { Boolean.TRUE, paramView, Integer.valueOf(paramInt) });
    if (this.FwX != null)
    {
      Log.i("MicroMsg.CollapseView", "setContent already have content layout");
      AppMethodBeat.o(178916);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.FwX = paramView;
    this.FwV.addView(this.FwX);
    this.FwV.setVisibility(0);
    this.FwV.setVisibility(0);
    setAlpha(0.0F);
    this.FwT.setAlpha(0.0F);
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
            if ((CollapseView.h(CollapseView.this) != null) && (!ad.eYc().Fsb))
            {
              p.p(1, CollapseView.h(CollapseView.this), 2);
              ad.eYc().Fsb = true;
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
  
  public final void dGn()
  {
    AppMethodBeat.i(197267);
    if ((this.Fxb.getTag() == null) || (this.Fxb.getTag().equals(Boolean.TRUE))) {
      eYu();
    }
    if ((this.BOy.getTag() == null) || (this.BOy.getTag().equals(Boolean.TRUE))) {
      eYv();
    }
    AppMethodBeat.o(197267);
  }
  
  public final void eYv()
  {
    AppMethodBeat.i(197275);
    int i;
    if ((this.BOy.getTag() == null) || (this.BOy.getTag().equals(Boolean.TRUE)))
    {
      this.BOy.setTag(Boolean.FALSE);
      i = 90;
      fs(this.FwV);
      if (this.Fxa != null) {
        p.p(2, this.Fxa, 1);
      }
      p.uG(true);
    }
    for (;;)
    {
      this.BOy.animate().setDuration(this.duration).rotation(i);
      AppMethodBeat.o(197275);
      return;
      i = 270;
      this.BOy.setTag(Boolean.TRUE);
      fu(this.FwV);
      if (this.Fxa != null) {
        p.p(2, this.Fxa, 2);
      }
      p.uG(false);
    }
  }
  
  public final void fq(View paramView)
  {
    AppMethodBeat.i(178917);
    Log.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", new Object[] { Boolean.TRUE, paramView });
    if (this.FwY != null)
    {
      Log.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
      AppMethodBeat.o(178917);
      return;
    }
    if ((ViewGroup)paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.FwY = paramView;
    this.FwU.addView(paramView);
    this.Fxb = ((ImageButton)paramView.findViewById(a.e.talking_hangup_btn));
    paramView = (RelativeLayout.LayoutParams)this.Fxb.getLayoutParams();
    paramView.width = f.FxW;
    paramView.height = f.FxW;
    paramView.bottomMargin = f.FxP;
    this.Fxb.setLayoutParams(paramView);
    AppMethodBeat.o(178917);
  }
  
  public final void fr(final View paramView)
  {
    AppMethodBeat.i(197264);
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
          if (paramView.getLayoutParams().height != f.FxS) {
            break;
          }
          AppMethodBeat.o(178910);
          return;
        }
        if (paramAnonymousFloat != 1.0F)
        {
          paramView.getLayoutParams().height = (f.FxW - (int)(this.Fxk * paramAnonymousFloat));
          paramView.getLayoutParams().width = (f.FxW - (int)(this.Fxk * paramAnonymousFloat));
          paramAnonymousTransformation = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          int i = f.FxP;
          paramAnonymousTransformation.bottomMargin = (i - (int)((i - f.FxO) * paramAnonymousFloat));
          ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.FxO * paramAnonymousFloat));
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
    AppMethodBeat.o(197264);
  }
  
  final void fu(final View paramView)
  {
    AppMethodBeat.i(178921);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ar.au(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    if (this.FwX != null) {
      this.FwX.setVisibility(0);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.FxR * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.FxJ * paramAnonymousFloat));
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
    C(paramMotionEvent);
    AppMethodBeat.o(178914);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178922);
    Log.d("MicroMsg.CollapseView", "event: " + paramMotionEvent.getAction());
    C(paramMotionEvent);
    AppMethodBeat.o(178922);
    return true;
  }
  
  public void setLinkToAutoMobileListener(final a parama)
  {
    AppMethodBeat.i(197324);
    if (findViewById(a.e.net_tip_layout) != null) {
      findViewById(a.e.net_tip_layout).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202638);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (CollapseView.this.findViewById(a.e.net_tip_layout) != null) {
            parama.onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(202638);
        }
      });
    }
    AppMethodBeat.o(197324);
  }
  
  public void setRoomKey(String paramString)
  {
    this.Fxa = paramString;
  }
  
  static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView
 * JD-Core Version:    0.7.0.1
 */