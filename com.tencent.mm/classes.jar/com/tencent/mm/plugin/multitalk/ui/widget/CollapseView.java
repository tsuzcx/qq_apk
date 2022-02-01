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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;

public class CollapseView
  extends LinearLayout
{
  private float cPz;
  long duration;
  Context mContext;
  private boolean olk;
  ImageView sDT;
  private RelativeLayout uZJ;
  private RelativeLayout uZK;
  RelativeLayout uZL;
  View uZM;
  private View uZN;
  private float uZO;
  String uZP;
  private ImageButton uZQ;
  private boolean uZR;
  private boolean uZS;
  private boolean uZT;
  private float uZU;
  private boolean uZV;
  
  public CollapseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178913);
    this.duration = 200L;
    this.uZO = 0.7F;
    this.olk = false;
    this.uZR = false;
    this.uZS = false;
    this.uZT = false;
    this.uZU = 0.0F;
    this.uZV = true;
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext).inflate(2131494972, this);
    this.uZL = ((RelativeLayout)findViewById(2131298743));
    this.uZK = ((RelativeLayout)findViewById(2131300676));
    this.sDT = ((ImageView)findViewById(2131302455));
    this.sDT.setBackground(am.k(paramContext, 2131690349, -1));
    this.uZJ = ((RelativeLayout)findViewById(2131302461));
    paramContext = this.uZJ;
    int i = f.vaE;
    paramAttributeSet = (View)paramContext.getParent();
    paramAttributeSet.post(new CollapseView.2(paramContext, i, paramAttributeSet));
    this.uZJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178905);
        int i;
        if (CollapseView.a(CollapseView.this))
        {
          CollapseView.a(CollapseView.this, false);
          paramAnonymousView = CollapseView.this;
          if ((paramAnonymousView.sDT.getTag() != null) && (!paramAnonymousView.sDT.getTag().equals(Boolean.TRUE))) {
            break label210;
          }
          paramAnonymousView.sDT.setTag(Boolean.FALSE);
          i = 90;
          RelativeLayout localRelativeLayout = paramAnonymousView.uZL;
          localRelativeLayout.measure(View.MeasureSpec.makeMeasureSpec(aj.cl(paramAnonymousView.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
          int j = localRelativeLayout.getMeasuredHeight();
          localRelativeLayout.setVisibility(0);
          if (paramAnonymousView.uZM != null) {
            paramAnonymousView.uZM.setVisibility(4);
          }
          CollapseView.6 local6 = new CollapseView.6(paramAnonymousView, localRelativeLayout, j);
          local6.setDuration(paramAnonymousView.duration);
          localRelativeLayout.startAnimation(local6);
          if (paramAnonymousView.uZP != null) {
            e.m(2, paramAnonymousView.uZP, 1);
          }
          e.os(true);
        }
        for (;;)
        {
          paramAnonymousView.sDT.animate().setDuration(paramAnonymousView.duration).rotation(i);
          CollapseView.b(CollapseView.this);
          AppMethodBeat.o(178905);
          return;
          label210:
          i = 270;
          paramAnonymousView.sDT.setTag(Boolean.TRUE);
          paramAnonymousView.em(paramAnonymousView.uZL);
          if (paramAnonymousView.uZP != null) {
            e.m(2, paramAnonymousView.uZP, 2);
          }
          e.os(false);
        }
      }
    });
    this.sDT.setRotation(270.0F);
    this.uZL.setVisibility(4);
    AppMethodBeat.o(178913);
  }
  
  private void dgG()
  {
    AppMethodBeat.i(178918);
    int i = (int)(270.0F + this.uZU * 180.0F);
    this.sDT.setRotation(i);
    ImageView localImageView = this.sDT;
    if (this.uZU == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localImageView.setTag(Boolean.valueOf(bool));
      this.sDT.requestLayout();
      AppMethodBeat.o(178918);
      return;
    }
  }
  
  private void el(View paramView)
  {
    AppMethodBeat.i(178920);
    int i = f.vaG;
    int j = f.vaE;
    i = f.vaE + (int)((i - j) * this.uZU);
    paramView.getLayoutParams().height = i;
    paramView.getLayoutParams().width = i;
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = (f.vaA + (int)((f.vaB - f.vaA) * this.uZU));
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.vaA * (1.0F - this.uZU)));
    paramView.requestLayout();
    paramView = this.uZQ;
    if (i != f.vaG) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(Boolean.valueOf(bool));
      AppMethodBeat.o(178920);
      return;
    }
  }
  
  private void s(View paramView, float paramFloat)
  {
    AppMethodBeat.i(178919);
    paramView.setVisibility(0);
    if (this.uZM != null) {
      this.uZM.setVisibility(4);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(aj.cl(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    int i = paramView.getMeasuredHeight();
    float f = paramView.getLayoutParams().height + paramFloat;
    View localView;
    if (f >= i)
    {
      paramFloat = i;
      this.uZU = (paramFloat / i);
      if (this.uZU >= this.uZO)
      {
        this.uZM.setVisibility(0);
        localView = this.uZM;
        if ((this.uZU - this.uZO + 0.1D) * 2.5D < 1.0D) {
          break label229;
        }
      }
    }
    label229:
    for (f = 1.0F;; f = (this.uZU - this.uZO + 0.1F) * 2.5F)
    {
      localView.setAlpha(f);
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(this.uZU * f.vaD));
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(this.uZU * f.vaw));
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
  
  private void y(MotionEvent paramMotionEvent)
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
            } while (this.uZR);
            this.cPz = paramMotionEvent.getRawY();
            AppMethodBeat.o(178915);
            return;
            f = paramMotionEvent.getRawY() - this.cPz;
          } while ((!this.uZR) && (Math.abs(f) < 5.0F));
          this.cPz = paramMotionEvent.getRawY();
        } while (Math.abs(f) <= 1.0F);
        s(this.uZL, -f);
        el(this.uZQ);
        dgG();
        if (f > 0.0F)
        {
          this.uZR = true;
          this.uZT = true;
          this.uZS = false;
          AppMethodBeat.o(178915);
          return;
        }
      } while (f >= 0.0F);
      this.uZR = true;
      this.uZS = true;
      this.uZT = false;
      AppMethodBeat.o(178915);
      return;
    }
    if ((this.uZU > this.uZO) && (this.uZU < 1.0F)) {
      this.uZS = true;
    }
    label408:
    for (;;)
    {
      boolean bool = false;
      label216:
      this.uZT = bool;
      label221:
      if ((this.uZS) && (this.uZR))
      {
        this.uZS = false;
        this.olk = true;
        s(this.uZL, 9999.0F);
        el(this.uZQ);
        dgG();
      }
      for (;;)
      {
        this.uZR = false;
        break;
        if ((this.uZU < 1.0F - this.uZO) && (this.uZU > 0.0F))
        {
          this.uZS = false;
          bool = true;
          break label216;
        }
        if ((this.uZU == 0.0F) || (this.uZU == 1.0F)) {
          break label221;
        }
        if (!this.uZS) {}
        for (bool = true;; bool = false)
        {
          this.uZS = bool;
          if (this.uZT) {
            break label408;
          }
          bool = true;
          break;
        }
        if ((this.uZT) && (this.uZR))
        {
          this.uZT = false;
          this.olk = false;
          s(this.uZL, -9999.0F);
          el(this.uZQ);
          dgG();
        }
      }
    }
  }
  
  public final void aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(178916);
    ac.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", new Object[] { Boolean.TRUE, paramView, Integer.valueOf(paramInt) });
    if (this.uZM != null)
    {
      ac.i("MicroMsg.CollapseView", "setContent already have content layout");
      AppMethodBeat.o(178916);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.uZM = paramView;
    this.uZL.addView(this.uZM);
    this.uZL.setVisibility(0);
    this.uZL.setVisibility(0);
    setAlpha(0.0F);
    this.uZJ.setAlpha(0.0F);
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
            if ((CollapseView.h(CollapseView.this) != null) && (!p.dgx().uXn))
            {
              e.m(1, CollapseView.h(CollapseView.this), 2);
              p.dgx().uXn = true;
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
  
  final void em(final View paramView)
  {
    AppMethodBeat.i(178921);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(aj.cl(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    if (this.uZM != null) {
      this.uZM.setVisibility(0);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.vaD * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.vaw * paramAnonymousFloat));
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
    y(paramMotionEvent);
    AppMethodBeat.o(178914);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178922);
    ac.d("MicroMsg.CollapseView", "event: " + paramMotionEvent.getAction());
    y(paramMotionEvent);
    AppMethodBeat.o(178922);
    return true;
  }
  
  public final void setCollapseContent$53599cc9(View paramView)
  {
    AppMethodBeat.i(178917);
    ac.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", new Object[] { Boolean.TRUE, paramView });
    if (this.uZN != null)
    {
      ac.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
      AppMethodBeat.o(178917);
      return;
    }
    if ((ViewGroup)paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.uZN = paramView;
    this.uZK.addView(paramView);
    this.uZQ = ((ImageButton)paramView.findViewById(2131305667));
    paramView = (RelativeLayout.LayoutParams)this.uZQ.getLayoutParams();
    paramView.width = f.vaG;
    paramView.height = f.vaG;
    paramView.bottomMargin = f.vaB;
    this.uZQ.setLayoutParams(paramView);
    AppMethodBeat.o(178917);
  }
  
  public void setRoomKey(String paramString)
  {
    this.uZP = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView
 * JD-Core Version:    0.7.0.1
 */