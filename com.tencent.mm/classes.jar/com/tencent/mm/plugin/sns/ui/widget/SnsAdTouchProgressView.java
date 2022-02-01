package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected float ATY;
  protected float ATZ;
  protected View AUa;
  protected com.tencent.mm.plugin.sns.ad.g.a.b AUb;
  protected FrameLayout.LayoutParams AUc;
  protected FrameLayout.LayoutParams AUd;
  protected FrameLayout.LayoutParams AUe;
  protected int AUf;
  protected int AUg;
  protected int AUh;
  protected boolean AUi;
  protected boolean AUj;
  protected AnimatorSet AUk;
  protected AnimatorSet AUl;
  protected AnimatorSet AUm;
  protected int AUn;
  protected Rect AUo;
  protected Paint AUp;
  protected boolean AUq;
  protected a AqB;
  protected GestureDetector lwM;
  protected Context mContext;
  protected View mInnerView;
  protected boolean mIsCanceled;
  protected boolean nOo;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.ATY = 0.0F;
    this.ATZ = 0.0F;
    this.AUi = false;
    this.nOo = false;
    this.mIsCanceled = false;
    this.AUj = false;
    this.AUn = 4000;
    this.AUq = false;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.ATY = 0.0F;
    this.ATZ = 0.0F;
    this.AUi = false;
    this.nOo = false;
    this.mIsCanceled = false;
    this.AUj = false;
    this.AUn = 4000;
    this.AUq = false;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void Ss(int paramInt)
  {
    AppMethodBeat.i(179411);
    int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.AUa, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(i);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.AUa, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.AUa, "alpha", new float[] { 0.0F, 0.4F });
    localObjectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator3.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.AUa, "alpha", new float[] { 0.4F, 0.4F });
    localObjectAnimator4.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.AUa, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(i);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.AUa, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.AUa, "alpha", new float[] { 0.4F, 0.2F });
    localObjectAnimator7.setDuration(i);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.AUa, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.AUa, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.AUa, "alpha", new float[] { 0.2F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.AUl = new AnimatorSet();
    this.AUl.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.AUl.play(localObjectAnimator4).after(localObjectAnimator1);
    this.AUl.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.AUl.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator5);
    AppMethodBeat.o(179411);
  }
  
  private void St(int paramInt)
  {
    AppMethodBeat.i(220149);
    final int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.AUb, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.AUb, "scaleX", new float[] { 1.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.AUb, "scaleY", new float[] { 1.0F, 1.0F });
    localObjectAnimator3.setDuration(i);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.AUb, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator4.setDuration(i);
    int j = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.AUb, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(j);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.AUb, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(j);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.AUb, "alpha", new float[] { 1.0F, 0.4F });
    localObjectAnimator7.setDuration(j);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.AUb, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.AUb, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.AUb, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.AUm = new AnimatorSet();
    this.AUm.play(localObjectAnimator1);
    this.AUm.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.AUm.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.AUm.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator7);
    localObjectAnimator2.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(179403);
        AppMethodBeat.o(179403);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(220146);
        ae.i("SnsAdTouchProgressView", "a1 onAnimationStart, startProgress, duration=" + i);
        SnsAdTouchProgressView.this.AUb.as(i, SnsAdTouchProgressView.this.AUg, SnsAdTouchProgressView.this.AUh);
        AppMethodBeat.o(220146);
      }
    });
    AppMethodBeat.o(220149);
  }
  
  private void Su(int paramInt)
  {
    AppMethodBeat.i(179412);
    int i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setDuration(i);
    localObjectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator4.setDuration(i);
    localObjectAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.8F, 0.8F });
    localObjectAnimator5.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", new float[] { 1.0F, 0.8888F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", new float[] { 1.0F, 0.8888F });
    localObjectAnimator7.setDuration(i);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.8F, 0.4F });
    localObjectAnimator8.setDuration(i);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.mInnerView, "scaleX", new float[] { 0.8888F, 1.625F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.mInnerView, "scaleY", new float[] { 0.8888F, 1.625F });
    localObjectAnimator10.setDuration(paramInt);
    ObjectAnimator localObjectAnimator11 = ObjectAnimator.ofFloat(this.mInnerView, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator11.setDuration(paramInt);
    this.AUk = new AnimatorSet();
    this.AUk.play(localObjectAnimator1);
    this.AUk.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.AUk.play(localObjectAnimator5).after(localObjectAnimator4);
    this.AUk.play(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).after(localObjectAnimator5);
    this.AUk.play(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator11).after(localObjectAnimator8);
    this.AUk.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(220147);
        ae.i("SnsAdTouchProgressView", "onAnimationEnd, isCanceled=" + SnsAdTouchProgressView.this.mIsCanceled);
        SnsAdTouchProgressView.this.nOo = false;
        if ((SnsAdTouchProgressView.this.AqB != null) && (!SnsAdTouchProgressView.this.mIsCanceled))
        {
          SnsAdTouchProgressView.this.AqB.onFinish();
          SnsAdTouchProgressView.this.AUi = true;
        }
        AppMethodBeat.o(220147);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(179412);
  }
  
  private void ic(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179415);
    int i = this.AUf;
    int j = this.AUf;
    int k = paramInt1 - this.AUg;
    int m = paramInt2 - this.AUg;
    this.AUc.leftMargin = (paramInt1 - i);
    this.AUc.topMargin = (paramInt2 - j);
    this.AUd.leftMargin = k;
    this.AUd.topMargin = m;
    this.AUe.leftMargin = k;
    this.AUe.topMargin = m;
    this.mInnerView.setLayoutParams(this.AUc);
    this.AUa.setLayoutParams(this.AUd);
    this.AUb.setLayoutParams(this.AUe);
    AppMethodBeat.o(179415);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.mInnerView = new View(paramContext);
    this.mInnerView.setBackgroundResource(2131234091);
    this.AUa = new View(paramContext);
    this.AUa.setBackgroundResource(2131234092);
    this.AUb = new com.tencent.mm.plugin.sns.ad.g.a.b(paramContext);
    this.AUf = com.tencent.mm.cb.a.fromDPToPix(paramContext, 36);
    this.AUg = com.tencent.mm.cb.a.fromDPToPix(paramContext, 68);
    this.AUh = com.tencent.mm.cb.a.fromDPToPix(paramContext, 6);
    this.AUc = new FrameLayout.LayoutParams(this.AUf * 2, this.AUf * 2);
    this.AUd = new FrameLayout.LayoutParams(this.AUg * 2, this.AUg * 2);
    this.AUe = new FrameLayout.LayoutParams(this.AUg * 2, this.AUg * 2);
    addView(this.AUa, this.AUd);
    addView(this.mInnerView, this.AUc);
    addView(this.AUb, this.AUe);
    ic(0, 0);
    this.AUa.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.AUb.setVisibility(4);
    Su(this.AUn);
    Ss(this.AUn);
    St(this.AUn);
    this.lwM = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179402);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        ae.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.nOo = true;
        SnsAdTouchProgressView.this.AUj = true;
        if (SnsAdTouchProgressView.this.AqB != null) {
          SnsAdTouchProgressView.this.AqB.onStart();
        }
        SnsAdTouchProgressView.this.bzX();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(179402);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
      
      public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179401);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (SnsAdTouchProgressView.this.AqB != null) {
          SnsAdTouchProgressView.this.AqB.onClick(SnsAdTouchProgressView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179401);
        return true;
      }
    });
    this.AUp = new Paint();
    this.AUp.setColor(Color.parseColor("#35FF0000"));
    AppMethodBeat.o(179407);
  }
  
  protected final void bzX()
  {
    AppMethodBeat.i(179414);
    ae.i("SnsAdTouchProgressView", "doOuterAnim");
    this.AUa.setVisibility(0);
    this.AUl.cancel();
    this.AUl.start();
    ae.i("SnsAdTouchProgressView", "doInnerAnim");
    this.mInnerView.setVisibility(0);
    this.AUk.cancel();
    this.AUk.start();
    ae.i("SnsAdTouchProgressView", "doCicleAnim");
    this.AUb.setVisibility(0);
    this.AUm.cancel();
    this.AUm.start();
    AppMethodBeat.o(179414);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179409);
    ae.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.AUa.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.AUb.setVisibility(4);
    this.AUl.cancel();
    this.AUk.cancel();
    this.AUm.cancel();
    this.AUb.clear();
    AppMethodBeat.o(179409);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(220148);
    if ((this.AUq) && (this.AUo != null)) {
      paramCanvas.drawRect(this.AUo, this.AUp);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(220148);
  }
  
  public final boolean isAnimating()
  {
    return this.nOo;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (this.AUo != null) && (!this.AUo.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      ae.w("SnsAdTouchProgressView", "onTouchEvent, x=" + paramMotionEvent.getX() + ", y=" + paramMotionEvent.getY() + ", range=" + this.AUo.toShortString());
      AppMethodBeat.o(179410);
      return false;
    }
    GestureDetector localGestureDetector = this.lwM;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (i == 0)
    {
      this.ATY = paramMotionEvent.getX();
      this.ATZ = paramMotionEvent.getY();
      ic((int)this.ATY, (int)this.ATZ);
      this.AUi = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        ae.i("SnsAdTouchProgressView", "onTouchEvent cancel， action=" + i + ", IsLongClicked=" + this.AUj + ", isSuccFinish=" + this.AUi);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.nOo = false;
        if ((!this.AUi) && (this.AUj) && (this.AqB != null)) {
          this.AqB.onCancel();
        }
        this.AUj = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.AqB = parama;
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(179408);
    ae.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.AUn;
    }
    Su(i);
    Ss(i);
    St(i);
    AppMethodBeat.o(179408);
  }
  
  public void setTouchRange(Rect paramRect)
  {
    this.AUo = paramRect;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onClick(View paramView);
    
    public abstract void onFinish();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView
 * JD-Core Version:    0.7.0.1
 */