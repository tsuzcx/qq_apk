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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;

public class CollapseView
  extends LinearLayout
{
  private float dbR;
  long duration;
  Context mContext;
  private boolean oVh;
  ImageView tLz;
  private ImageButton wuA;
  private boolean wuB;
  private boolean wuC;
  private boolean wuD;
  private float wuE;
  private boolean wuF;
  private RelativeLayout wut;
  private RelativeLayout wuu;
  RelativeLayout wuv;
  View wuw;
  private View wux;
  private float wuy;
  String wuz;
  
  public CollapseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178913);
    this.duration = 200L;
    this.wuy = 0.7F;
    this.oVh = false;
    this.wuB = false;
    this.wuC = false;
    this.wuD = false;
    this.wuE = 0.0F;
    this.wuF = true;
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext).inflate(2131494972, this);
    this.wuv = ((RelativeLayout)findViewById(2131298743));
    this.wuu = ((RelativeLayout)findViewById(2131300676));
    this.tLz = ((ImageView)findViewById(2131302455));
    this.tLz.setBackground(ao.k(paramContext, 2131690349, -1));
    this.wut = ((RelativeLayout)findViewById(2131302461));
    paramContext = this.wut;
    int i = f.wvq;
    paramAttributeSet = (View)paramContext.getParent();
    paramAttributeSet.post(new CollapseView.2(paramContext, i, paramAttributeSet));
    this.wut.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178905);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        int i;
        if (CollapseView.a(CollapseView.this))
        {
          CollapseView.a(CollapseView.this, false);
          paramAnonymousView = CollapseView.this;
          if ((paramAnonymousView.tLz.getTag() != null) && (!paramAnonymousView.tLz.getTag().equals(Boolean.TRUE))) {
            break label254;
          }
          paramAnonymousView.tLz.setTag(Boolean.FALSE);
          i = 90;
          localObject = paramAnonymousView.wuv;
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(al.ck(paramAnonymousView.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
          int j = ((View)localObject).getMeasuredHeight();
          ((View)localObject).setVisibility(0);
          if (paramAnonymousView.wuw != null) {
            paramAnonymousView.wuw.setVisibility(4);
          }
          CollapseView.6 local6 = new CollapseView.6(paramAnonymousView, (View)localObject, j);
          local6.setDuration(paramAnonymousView.duration);
          ((View)localObject).startAnimation(local6);
          if (paramAnonymousView.wuz != null) {
            n.m(2, paramAnonymousView.wuz, 1);
          }
          n.oV(true);
        }
        for (;;)
        {
          paramAnonymousView.tLz.animate().setDuration(paramAnonymousView.duration).rotation(i);
          CollapseView.b(CollapseView.this);
          a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(178905);
          return;
          label254:
          i = 270;
          paramAnonymousView.tLz.setTag(Boolean.TRUE);
          paramAnonymousView.ev(paramAnonymousView.wuv);
          if (paramAnonymousView.wuz != null) {
            n.m(2, paramAnonymousView.wuz, 2);
          }
          n.oV(false);
        }
      }
    });
    this.tLz.setRotation(270.0F);
    this.wuv.setVisibility(4);
    AppMethodBeat.o(178913);
  }
  
  private void dtV()
  {
    AppMethodBeat.i(178918);
    int i = (int)(270.0F + this.wuE * 180.0F);
    this.tLz.setRotation(i);
    ImageView localImageView = this.tLz;
    if (this.wuE == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localImageView.setTag(Boolean.valueOf(bool));
      this.tLz.requestLayout();
      AppMethodBeat.o(178918);
      return;
    }
  }
  
  private void eu(View paramView)
  {
    AppMethodBeat.i(178920);
    int i = f.wvs;
    int j = f.wvq;
    i = f.wvq + (int)((i - j) * this.wuE);
    paramView.getLayoutParams().height = i;
    paramView.getLayoutParams().width = i;
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = (f.wvm + (int)((f.wvn - f.wvm) * this.wuE));
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.wvm * (1.0F - this.wuE)));
    paramView.requestLayout();
    paramView = this.wuA;
    if (i != f.wvs) {}
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
    if (this.wuw != null) {
      this.wuw.setVisibility(4);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(al.ck(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    int i = paramView.getMeasuredHeight();
    float f = paramView.getLayoutParams().height + paramFloat;
    View localView;
    if (f >= i)
    {
      paramFloat = i;
      this.wuE = (paramFloat / i);
      if (this.wuE >= this.wuy)
      {
        this.wuw.setVisibility(0);
        localView = this.wuw;
        if ((this.wuE - this.wuy + 0.1D) * 2.5D < 1.0D) {
          break label229;
        }
      }
    }
    label229:
    for (f = 1.0F;; f = (this.wuE - this.wuy + 0.1F) * 2.5F)
    {
      localView.setAlpha(f);
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(this.wuE * f.wvp));
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(this.wuE * f.wvi));
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
  
  private void w(MotionEvent paramMotionEvent)
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
            } while (this.wuB);
            this.dbR = paramMotionEvent.getRawY();
            AppMethodBeat.o(178915);
            return;
            f = paramMotionEvent.getRawY() - this.dbR;
          } while ((!this.wuB) && (Math.abs(f) < 5.0F));
          this.dbR = paramMotionEvent.getRawY();
        } while (Math.abs(f) <= 1.0F);
        s(this.wuv, -f);
        eu(this.wuA);
        dtV();
        if (f > 0.0F)
        {
          this.wuB = true;
          this.wuD = true;
          this.wuC = false;
          AppMethodBeat.o(178915);
          return;
        }
      } while (f >= 0.0F);
      this.wuB = true;
      this.wuC = true;
      this.wuD = false;
      AppMethodBeat.o(178915);
      return;
    }
    if ((this.wuE > this.wuy) && (this.wuE < 1.0F)) {
      this.wuC = true;
    }
    label408:
    for (;;)
    {
      boolean bool = false;
      label216:
      this.wuD = bool;
      label221:
      if ((this.wuC) && (this.wuB))
      {
        this.wuC = false;
        this.oVh = true;
        s(this.wuv, 9999.0F);
        eu(this.wuA);
        dtV();
      }
      for (;;)
      {
        this.wuB = false;
        break;
        if ((this.wuE < 1.0F - this.wuy) && (this.wuE > 0.0F))
        {
          this.wuC = false;
          bool = true;
          break label216;
        }
        if ((this.wuE == 0.0F) || (this.wuE == 1.0F)) {
          break label221;
        }
        if (!this.wuC) {}
        for (bool = true;; bool = false)
        {
          this.wuC = bool;
          if (this.wuD) {
            break label408;
          }
          bool = true;
          break;
        }
        if ((this.wuD) && (this.wuB))
        {
          this.wuD = false;
          this.oVh = false;
          s(this.wuv, -9999.0F);
          eu(this.wuA);
          dtV();
        }
      }
    }
  }
  
  public final void ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(178916);
    ae.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", new Object[] { Boolean.TRUE, paramView, Integer.valueOf(paramInt) });
    if (this.wuw != null)
    {
      ae.i("MicroMsg.CollapseView", "setContent already have content layout");
      AppMethodBeat.o(178916);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.wuw = paramView;
    this.wuv.addView(this.wuw);
    this.wuv.setVisibility(0);
    this.wuv.setVisibility(0);
    setAlpha(0.0F);
    this.wut.setAlpha(0.0F);
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
            if ((CollapseView.h(CollapseView.this) != null) && (!z.dtK().wqX))
            {
              n.m(1, CollapseView.h(CollapseView.this), 2);
              z.dtK().wqX = true;
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
  
  final void ev(final View paramView)
  {
    AppMethodBeat.i(178921);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(al.ck(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    if (this.wuw != null) {
      this.wuw.setVisibility(0);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.wvp * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.wvi * paramAnonymousFloat));
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
    w(paramMotionEvent);
    AppMethodBeat.o(178914);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(178922);
    ae.d("MicroMsg.CollapseView", "event: " + paramMotionEvent.getAction());
    w(paramMotionEvent);
    AppMethodBeat.o(178922);
    return true;
  }
  
  public final void setCollapseContent$53599cc9(View paramView)
  {
    AppMethodBeat.i(178917);
    ae.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", new Object[] { Boolean.TRUE, paramView });
    if (this.wux != null)
    {
      ae.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
      AppMethodBeat.o(178917);
      return;
    }
    if ((ViewGroup)paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.wux = paramView;
    this.wuu.addView(paramView);
    this.wuA = ((ImageButton)paramView.findViewById(2131305667));
    paramView = (RelativeLayout.LayoutParams)this.wuA.getLayoutParams();
    paramView.width = f.wvs;
    paramView.height = f.wvs;
    paramView.bottomMargin = f.wvn;
    this.wuA.setLayoutParams(paramView);
    AppMethodBeat.o(178917);
  }
  
  public void setRoomKey(String paramString)
  {
    this.wuz = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView
 * JD-Core Version:    0.7.0.1
 */