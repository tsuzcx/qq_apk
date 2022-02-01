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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.e;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;

public class CollapseView
  extends LinearLayout
{
  private float cSf;
  long duration;
  Context mContext;
  private boolean nIk;
  ImageView rvb;
  private RelativeLayout tRb;
  private RelativeLayout tRc;
  RelativeLayout tRd;
  View tRe;
  private View tRf;
  private float tRg;
  String tRh;
  private ImageButton tRi;
  private boolean tRj;
  private boolean tRk;
  private boolean tRl;
  private float tRm;
  private boolean tRn;
  
  public CollapseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178913);
    this.duration = 200L;
    this.tRg = 0.7F;
    this.nIk = false;
    this.tRj = false;
    this.tRk = false;
    this.tRl = false;
    this.tRm = 0.0F;
    this.tRn = true;
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext).inflate(2131494972, this);
    this.tRd = ((RelativeLayout)findViewById(2131298743));
    this.tRc = ((RelativeLayout)findViewById(2131300676));
    this.rvb = ((ImageView)findViewById(2131302455));
    this.rvb.setBackground(am.i(paramContext, 2131690349, -1));
    this.tRb = ((RelativeLayout)findViewById(2131302461));
    paramContext = this.tRb;
    int i = f.tRX;
    paramAttributeSet = (View)paramContext.getParent();
    paramAttributeSet.post(new CollapseView.2(paramContext, i, paramAttributeSet));
    this.tRb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178905);
        int i;
        if (CollapseView.a(CollapseView.this))
        {
          CollapseView.a(CollapseView.this, false);
          paramAnonymousView = CollapseView.this;
          if ((paramAnonymousView.rvb.getTag() != null) && (!paramAnonymousView.rvb.getTag().equals(Boolean.TRUE))) {
            break label210;
          }
          paramAnonymousView.rvb.setTag(Boolean.FALSE);
          i = 90;
          RelativeLayout localRelativeLayout = paramAnonymousView.tRd;
          localRelativeLayout.measure(View.MeasureSpec.makeMeasureSpec(ai.cf(paramAnonymousView.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
          int j = localRelativeLayout.getMeasuredHeight();
          localRelativeLayout.setVisibility(0);
          if (paramAnonymousView.tRe != null) {
            paramAnonymousView.tRe.setVisibility(4);
          }
          CollapseView.6 local6 = new CollapseView.6(paramAnonymousView, localRelativeLayout, j);
          local6.setDuration(paramAnonymousView.duration);
          localRelativeLayout.startAnimation(local6);
          if (paramAnonymousView.tRh != null) {
            e.k(2, paramAnonymousView.tRh, 1);
          }
          e.ny(true);
        }
        for (;;)
        {
          paramAnonymousView.rvb.animate().setDuration(paramAnonymousView.duration).rotation(i);
          CollapseView.b(CollapseView.this);
          AppMethodBeat.o(178905);
          return;
          label210:
          i = 270;
          paramAnonymousView.rvb.setTag(Boolean.TRUE);
          paramAnonymousView.ed(paramAnonymousView.tRd);
          if (paramAnonymousView.tRh != null) {
            e.k(2, paramAnonymousView.tRh, 2);
          }
          e.ny(false);
        }
      }
    });
    this.rvb.setRotation(270.0F);
    this.tRd.setVisibility(4);
    AppMethodBeat.o(178913);
  }
  
  private void A(MotionEvent paramMotionEvent)
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
            } while (this.tRj);
            this.cSf = paramMotionEvent.getRawY();
            AppMethodBeat.o(178915);
            return;
            f = paramMotionEvent.getRawY() - this.cSf;
          } while ((!this.tRj) && (Math.abs(f) < 5.0F));
          this.cSf = paramMotionEvent.getRawY();
        } while (Math.abs(f) <= 1.0F);
        r(this.tRd, -f);
        ec(this.tRi);
        cSW();
        if (f > 0.0F)
        {
          this.tRj = true;
          this.tRl = true;
          this.tRk = false;
          AppMethodBeat.o(178915);
          return;
        }
      } while (f >= 0.0F);
      this.tRj = true;
      this.tRk = true;
      this.tRl = false;
      AppMethodBeat.o(178915);
      return;
    }
    if ((this.tRm > this.tRg) && (this.tRm < 1.0F)) {
      this.tRk = true;
    }
    label401:
    for (;;)
    {
      boolean bool = false;
      label211:
      this.tRl = bool;
      label216:
      if ((this.tRk) && (this.tRj))
      {
        this.tRk = false;
        this.nIk = true;
        r(this.tRd, 9999.0F);
        ec(this.tRi);
        cSW();
      }
      for (;;)
      {
        this.tRj = false;
        break;
        if ((this.tRm < 1.0F - this.tRg) && (this.tRm > 0.0F))
        {
          this.tRk = false;
          bool = true;
          break label211;
        }
        if ((this.tRm == 0.0F) || (this.tRm == 1.0F)) {
          break label216;
        }
        if (!this.tRk) {}
        for (bool = true;; bool = false)
        {
          this.tRk = bool;
          if (this.tRl) {
            break label401;
          }
          bool = true;
          break;
        }
        if ((this.tRl) && (this.tRj))
        {
          this.tRl = false;
          this.nIk = false;
          r(this.tRd, -9999.0F);
          ec(this.tRi);
          cSW();
        }
      }
    }
  }
  
  private void cSW()
  {
    AppMethodBeat.i(178918);
    int i = (int)(270.0F + this.tRm * 180.0F);
    this.rvb.setRotation(i);
    ImageView localImageView = this.rvb;
    if (this.tRm == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localImageView.setTag(Boolean.valueOf(bool));
      this.rvb.requestLayout();
      AppMethodBeat.o(178918);
      return;
    }
  }
  
  private void ec(View paramView)
  {
    AppMethodBeat.i(178920);
    int i = f.tRZ;
    int j = f.tRX;
    i = f.tRX + (int)((i - j) * this.tRm);
    paramView.getLayoutParams().height = i;
    paramView.getLayoutParams().width = i;
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = (f.tRT + (int)((f.tRU - f.tRT) * this.tRm));
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.tRT * (1.0F - this.tRm)));
    paramView.requestLayout();
    paramView = this.tRi;
    if (i != f.tRZ) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(Boolean.valueOf(bool));
      AppMethodBeat.o(178920);
      return;
    }
  }
  
  private void r(View paramView, float paramFloat)
  {
    AppMethodBeat.i(178919);
    paramView.setVisibility(0);
    if (this.tRe != null) {
      this.tRe.setVisibility(4);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ai.cf(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    int i = paramView.getMeasuredHeight();
    float f = paramView.getLayoutParams().height + paramFloat;
    View localView;
    if (f >= i)
    {
      paramFloat = i;
      this.tRm = (paramFloat / i);
      if (this.tRm >= this.tRg)
      {
        this.tRe.setVisibility(0);
        localView = this.tRe;
        if ((this.tRm - this.tRg + 0.1D) * 2.5D < 1.0D) {
          break label229;
        }
      }
    }
    label229:
    for (f = 1.0F;; f = (this.tRm - this.tRg + 0.1F) * 2.5F)
    {
      localView.setAlpha(f);
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(this.tRm * f.tRW));
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(this.tRm * f.tRP));
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
  
  public final void ai(View paramView, int paramInt)
  {
    AppMethodBeat.i(178916);
    ad.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", new Object[] { Boolean.TRUE, paramView, Integer.valueOf(paramInt) });
    if (this.tRe != null)
    {
      ad.i("MicroMsg.CollapseView", "setContent already have content layout");
      AppMethodBeat.o(178916);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.tRe = paramView;
    this.tRd.addView(this.tRe);
    this.tRd.setVisibility(0);
    this.tRd.setVisibility(0);
    setAlpha(0.0F);
    this.tRb.setAlpha(0.0F);
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
            if ((CollapseView.h(CollapseView.this) != null) && (!p.cSO().tOL))
            {
              e.k(1, CollapseView.h(CollapseView.this), 2);
              p.cSO().tOL = true;
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
  
  final void ed(final View paramView)
  {
    AppMethodBeat.i(178921);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ai.cf(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    if (this.tRe != null) {
      this.tRe.setVisibility(0);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.tRW * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.tRP * paramAnonymousFloat));
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
    A(paramMotionEvent);
    AppMethodBeat.o(178914);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178922);
    ad.d("MicroMsg.CollapseView", "event: " + paramMotionEvent.getAction());
    A(paramMotionEvent);
    AppMethodBeat.o(178922);
    return true;
  }
  
  public final void setCollapseContent$53599cc9(View paramView)
  {
    AppMethodBeat.i(178917);
    ad.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", new Object[] { Boolean.TRUE, paramView });
    if (this.tRf != null)
    {
      ad.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
      AppMethodBeat.o(178917);
      return;
    }
    if ((ViewGroup)paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.tRf = paramView;
    this.tRc.addView(paramView);
    this.tRi = ((ImageButton)paramView.findViewById(2131305667));
    paramView = (RelativeLayout.LayoutParams)this.tRi.getLayoutParams();
    paramView.width = f.tRZ;
    paramView.height = f.tRZ;
    paramView.bottomMargin = f.tRU;
    this.tRi.setLayoutParams(paramView);
    AppMethodBeat.o(178917);
  }
  
  public void setRoomKey(String paramString)
  {
    this.tRh = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView
 * JD-Core Version:    0.7.0.1
 */