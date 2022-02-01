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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;

public class CollapseView
  extends LinearLayout
{
  private float dsz;
  private long duration;
  private Context mContext;
  private boolean qkb;
  private ImageView xcA;
  private boolean zRA;
  private float zRB;
  private boolean zRC;
  private RelativeLayout zRq;
  private RelativeLayout zRr;
  private RelativeLayout zRs;
  private View zRt;
  private View zRu;
  private float zRv;
  private String zRw;
  private ImageButton zRx;
  private boolean zRy;
  private boolean zRz;
  
  public CollapseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(178913);
    this.duration = 200L;
    this.zRv = 0.7F;
    this.qkb = false;
    this.zRy = false;
    this.zRz = false;
    this.zRA = false;
    this.zRB = 0.0F;
    this.zRC = true;
    this.mContext = paramContext;
    LayoutInflater.from(this.mContext).inflate(2131495726, this);
    this.zRs = ((RelativeLayout)findViewById(2131299185));
    this.zRr = ((RelativeLayout)findViewById(2131302245));
    this.xcA = ((ImageView)findViewById(2131304861));
    this.xcA.setBackground(ar.m(paramContext, 2131690481, -1));
    this.zRq = ((RelativeLayout)findViewById(2131304870));
    paramContext = this.zRq;
    int i = f.zSq;
    paramAttributeSet = (View)paramContext.getParent();
    paramAttributeSet.post(new CollapseView.2(paramContext, i, paramAttributeSet));
    this.zRq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(178905);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (CollapseView.a(CollapseView.this))
        {
          if (ac.eom().enA().emb()) {
            p.zMu += 1;
          }
          CollapseView.a(CollapseView.this, false);
          CollapseView.this.eoE();
          CollapseView.b(CollapseView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/CollapseView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(178905);
      }
    });
    this.xcA.setRotation(270.0F);
    this.zRs.setVisibility(4);
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
            } while (this.zRy);
            this.dsz = paramMotionEvent.getRawY();
            AppMethodBeat.o(178915);
            return;
            f = paramMotionEvent.getRawY() - this.dsz;
          } while ((!this.zRy) && (Math.abs(f) < 5.0F));
          this.dsz = paramMotionEvent.getRawY();
        } while (Math.abs(f) <= 1.0F);
        x(this.zRs, -f);
        et(this.zRx);
        eoF();
        if (f > 0.0F)
        {
          this.zRy = true;
          this.zRA = true;
          this.zRz = false;
          AppMethodBeat.o(178915);
          return;
        }
      } while (f >= 0.0F);
      this.zRy = true;
      this.zRz = true;
      this.zRA = false;
      AppMethodBeat.o(178915);
      return;
    }
    if ((this.zRB > this.zRv) && (this.zRB < 1.0F)) {
      this.zRz = true;
    }
    label401:
    for (;;)
    {
      boolean bool = false;
      label211:
      this.zRA = bool;
      label216:
      if ((this.zRz) && (this.zRy))
      {
        this.zRz = false;
        this.qkb = true;
        x(this.zRs, 9999.0F);
        et(this.zRx);
        eoF();
      }
      for (;;)
      {
        this.zRy = false;
        break;
        if ((this.zRB < 1.0F - this.zRv) && (this.zRB > 0.0F))
        {
          this.zRz = false;
          bool = true;
          break label211;
        }
        if ((this.zRB == 0.0F) || (this.zRB == 1.0F)) {
          break label216;
        }
        if (!this.zRz) {}
        for (bool = true;; bool = false)
        {
          this.zRz = bool;
          if (this.zRA) {
            break label401;
          }
          bool = true;
          break;
        }
        if ((this.zRA) && (this.zRy))
        {
          this.zRA = false;
          this.qkb = false;
          x(this.zRs, -9999.0F);
          et(this.zRx);
          eoF();
        }
      }
    }
  }
  
  private void eoC()
  {
    AppMethodBeat.i(239455);
    if (this.zRx != null)
    {
      if ((this.zRx.getTag() == null) || (this.zRx.getTag().equals(Boolean.TRUE)))
      {
        this.zRx.setTag(Boolean.FALSE);
        localImageButton = this.zRx;
        int i = f.zSu;
        localImageButton.measure(i, i);
        localObject = new Animation()
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
            for (int i = f.zSn;; i = f.zSm + (int)((f.zSn - f.zSm) * paramAnonymousFloat))
            {
              paramAnonymousTransformation.bottomMargin = i;
              ((RelativeLayout.LayoutParams)localImageButton.getLayoutParams()).topMargin = ((int)(f.zSm * (1.0F - paramAnonymousFloat)));
              localImageButton.requestLayout();
              AppMethodBeat.o(178909);
              return;
              bool = false;
              break;
              i = f.zSq + (int)(this.wHn * paramAnonymousFloat);
              break label47;
              i = f.zSq + (int)(this.wHn * paramAnonymousFloat);
              break label69;
            }
          }
          
          public final boolean willChangeBounds()
          {
            return true;
          }
        };
        ((Animation)localObject).setDuration(this.duration);
        localImageButton.startAnimation((Animation)localObject);
        AppMethodBeat.o(239455);
        return;
      }
      this.zRx.setTag(Boolean.TRUE);
      final ImageButton localImageButton = this.zRx;
      Object localObject = new Animation()
      {
        protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
        {
          AppMethodBeat.i(178910);
          paramAnonymousTransformation = CollapseView.this;
          if (paramAnonymousFloat == 1.0F) {}
          for (boolean bool = true;; bool = false)
          {
            CollapseView.a(paramAnonymousTransformation, bool);
            if (localImageButton.getLayoutParams().height != f.zSq) {
              break;
            }
            AppMethodBeat.o(178910);
            return;
          }
          if (paramAnonymousFloat != 1.0F)
          {
            localImageButton.getLayoutParams().height = (f.zSu - (int)(this.zRG * paramAnonymousFloat));
            localImageButton.getLayoutParams().width = (f.zSu - (int)(this.zRG * paramAnonymousFloat));
            paramAnonymousTransformation = (RelativeLayout.LayoutParams)localImageButton.getLayoutParams();
            int i = f.zSn;
            paramAnonymousTransformation.bottomMargin = (i - (int)((i - f.zSm) * paramAnonymousFloat));
            ((RelativeLayout.LayoutParams)localImageButton.getLayoutParams()).topMargin = ((int)(f.zSm * paramAnonymousFloat));
            localImageButton.requestLayout();
          }
          AppMethodBeat.o(178910);
        }
        
        public final boolean willChangeBounds()
        {
          return true;
        }
      };
      ((Animation)localObject).setDuration(this.duration);
      localImageButton.startAnimation((Animation)localObject);
    }
    AppMethodBeat.o(239455);
  }
  
  private void eoF()
  {
    AppMethodBeat.i(178918);
    int i = (int)(270.0F + this.zRB * 180.0F);
    this.xcA.setRotation(i);
    ImageView localImageView = this.xcA;
    if (this.zRB == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localImageView.setTag(Boolean.valueOf(bool));
      this.xcA.requestLayout();
      AppMethodBeat.o(178918);
      return;
    }
  }
  
  private void es(final View paramView)
  {
    AppMethodBeat.i(239458);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ao.az(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    paramView.setVisibility(0);
    if (this.zRt != null) {
      this.zRt.setVisibility(4);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.zSp * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.zSh * paramAnonymousFloat));
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
    AppMethodBeat.o(239458);
  }
  
  private void et(View paramView)
  {
    AppMethodBeat.i(178920);
    int i = f.zSu;
    int j = f.zSq;
    i = f.zSq + (int)((i - j) * this.zRB);
    paramView.getLayoutParams().height = i;
    paramView.getLayoutParams().width = i;
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = (f.zSm + (int)((f.zSn - f.zSm) * this.zRB));
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.zSm * (1.0F - this.zRB)));
    paramView.requestLayout();
    paramView = this.zRx;
    if (i != f.zSu) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setTag(Boolean.valueOf(bool));
      AppMethodBeat.o(178920);
      return;
    }
  }
  
  private void eu(final View paramView)
  {
    AppMethodBeat.i(178921);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ao.az(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    final int i = paramView.getMeasuredHeight();
    if (this.zRt != null) {
      this.zRt.setVisibility(0);
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
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(f.zSp * paramAnonymousFloat));
          ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(f.zSh * paramAnonymousFloat));
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
  
  private void x(View paramView, float paramFloat)
  {
    AppMethodBeat.i(178919);
    paramView.setVisibility(0);
    if (this.zRt != null) {
      this.zRt.setVisibility(4);
    }
    paramView.measure(View.MeasureSpec.makeMeasureSpec(ao.az(this.mContext).x, 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, -2147483648));
    int i = paramView.getMeasuredHeight();
    float f = paramView.getLayoutParams().height + paramFloat;
    View localView;
    if (f >= i)
    {
      paramFloat = i;
      this.zRB = (paramFloat / i);
      if (this.zRB >= this.zRv)
      {
        this.zRt.setVisibility(0);
        localView = this.zRt;
        if ((this.zRB - this.zRv + 0.1D) * 2.5D < 1.0D) {
          break label229;
        }
      }
    }
    label229:
    for (f = 1.0F;; f = (this.zRB - this.zRv + 0.1F) * 2.5F)
    {
      localView.setAlpha(f);
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin = ((int)(this.zRB * f.zSp));
      ((LinearLayout.LayoutParams)paramView.getLayoutParams()).bottomMargin = ((int)(this.zRB * f.zSh));
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
  
  public final void Rr(int paramInt)
  {
    AppMethodBeat.i(239459);
    if (this.zRx != null) {
      this.zRx.setRotation(360 - paramInt);
    }
    AppMethodBeat.o(239459);
  }
  
  public final void am(View paramView, int paramInt)
  {
    AppMethodBeat.i(178916);
    Log.i("MicroMsg.CollapseView", "setContent animate:%s, controlView:%s, height:%s", new Object[] { Boolean.TRUE, paramView, Integer.valueOf(paramInt) });
    if (this.zRt != null)
    {
      Log.i("MicroMsg.CollapseView", "setContent already have content layout");
      AppMethodBeat.o(178916);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.zRt = paramView;
    this.zRs.addView(this.zRt);
    this.zRs.setVisibility(0);
    this.zRs.setVisibility(0);
    setAlpha(0.0F);
    this.zRq.setAlpha(0.0F);
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
            if ((CollapseView.h(CollapseView.this) != null) && (!ac.eom().zMH))
            {
              p.n(1, CollapseView.h(CollapseView.this), 2);
              ac.eom().zMH = true;
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
  
  public final void eoD()
  {
    AppMethodBeat.i(239456);
    if ((this.zRx.getTag() == null) || (this.zRx.getTag().equals(Boolean.TRUE))) {
      eoC();
    }
    if ((this.xcA.getTag() == null) || (this.xcA.getTag().equals(Boolean.TRUE))) {
      eoE();
    }
    AppMethodBeat.o(239456);
  }
  
  public final void eoE()
  {
    AppMethodBeat.i(239457);
    int i;
    if ((this.xcA.getTag() == null) || (this.xcA.getTag().equals(Boolean.TRUE)))
    {
      this.xcA.setTag(Boolean.FALSE);
      i = 90;
      es(this.zRs);
      if (this.zRw != null) {
        p.n(2, this.zRw, 1);
      }
      p.rD(true);
    }
    for (;;)
    {
      this.xcA.animate().setDuration(this.duration).rotation(i);
      AppMethodBeat.o(239457);
      return;
      i = 270;
      this.xcA.setTag(Boolean.TRUE);
      eu(this.zRs);
      if (this.zRw != null) {
        p.n(2, this.zRw, 2);
      }
      p.rD(false);
    }
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
    Log.d("MicroMsg.CollapseView", "event: " + paramMotionEvent.getAction());
    A(paramMotionEvent);
    AppMethodBeat.o(178922);
    return true;
  }
  
  public final void setCollapseContent$53599cc9(View paramView)
  {
    AppMethodBeat.i(178917);
    Log.i("MicroMsg.CollapseView", "setCollapseContent, animate:%s, collapseView:%s", new Object[] { Boolean.TRUE, paramView });
    if (this.zRu != null)
    {
      Log.i("MicroMsg.CollapseView", "setCollapseContent already has collapseView");
      AppMethodBeat.o(178917);
      return;
    }
    if ((ViewGroup)paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    this.zRu = paramView;
    this.zRr.addView(paramView);
    this.zRx = ((ImageButton)paramView.findViewById(2131308912));
    paramView = (RelativeLayout.LayoutParams)this.zRx.getLayoutParams();
    paramView.width = f.zSu;
    paramView.height = f.zSu;
    paramView.bottomMargin = f.zSn;
    this.zRx.setLayoutParams(paramView);
    AppMethodBeat.o(178917);
  }
  
  public void setRoomKey(String paramString)
  {
    this.zRw = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView
 * JD-Core Version:    0.7.0.1
 */