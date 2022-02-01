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
import com.tencent.mm.sdk.platformtools.ad;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected com.tencent.mm.plugin.sns.ad.f.a.b ACA;
  protected FrameLayout.LayoutParams ACB;
  protected FrameLayout.LayoutParams ACC;
  protected FrameLayout.LayoutParams ACD;
  protected int ACE;
  protected int ACF;
  protected int ACG;
  protected boolean ACH;
  protected boolean ACI;
  protected AnimatorSet ACJ;
  protected AnimatorSet ACK;
  protected AnimatorSet ACL;
  protected int ACM;
  protected Rect ACN;
  protected Paint ACO;
  protected boolean ACP;
  protected float ACx;
  protected float ACy;
  protected View ACz;
  protected GestureDetector lsn;
  protected Context mContext;
  protected View mInnerView;
  protected boolean mIsCanceled;
  protected boolean nIL;
  protected a zZo;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.ACx = 0.0F;
    this.ACy = 0.0F;
    this.ACH = false;
    this.nIL = false;
    this.mIsCanceled = false;
    this.ACI = false;
    this.ACM = 4000;
    this.ACP = false;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.ACx = 0.0F;
    this.ACy = 0.0F;
    this.ACH = false;
    this.nIL = false;
    this.mIsCanceled = false;
    this.ACI = false;
    this.ACM = 4000;
    this.ACP = false;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void RL(int paramInt)
  {
    AppMethodBeat.i(179411);
    int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.ACz, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(i);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.ACz, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.ACz, "alpha", new float[] { 0.0F, 0.4F });
    localObjectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator3.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.ACz, "alpha", new float[] { 0.4F, 0.4F });
    localObjectAnimator4.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.ACz, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(i);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.ACz, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.ACz, "alpha", new float[] { 0.4F, 0.2F });
    localObjectAnimator7.setDuration(i);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.ACz, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.ACz, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.ACz, "alpha", new float[] { 0.2F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.ACK = new AnimatorSet();
    this.ACK.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.ACK.play(localObjectAnimator4).after(localObjectAnimator1);
    this.ACK.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.ACK.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator5);
    AppMethodBeat.o(179411);
  }
  
  private void RM(int paramInt)
  {
    AppMethodBeat.i(198602);
    final int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.ACA, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.ACA, "scaleX", new float[] { 1.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.ACA, "scaleY", new float[] { 1.0F, 1.0F });
    localObjectAnimator3.setDuration(i);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.ACA, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator4.setDuration(i);
    int j = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.ACA, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(j);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.ACA, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(j);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.ACA, "alpha", new float[] { 1.0F, 0.4F });
    localObjectAnimator7.setDuration(j);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.ACA, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.ACA, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.ACA, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.ACL = new AnimatorSet();
    this.ACL.play(localObjectAnimator1);
    this.ACL.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.ACL.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.ACL.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator7);
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
        AppMethodBeat.i(198599);
        ad.i("SnsAdTouchProgressView", "a1 onAnimationStart, startProgress, duration=" + i);
        SnsAdTouchProgressView.this.ACA.ar(i, SnsAdTouchProgressView.this.ACF, SnsAdTouchProgressView.this.ACG);
        AppMethodBeat.o(198599);
      }
    });
    AppMethodBeat.o(198602);
  }
  
  private void RN(int paramInt)
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
    this.ACJ = new AnimatorSet();
    this.ACJ.play(localObjectAnimator1);
    this.ACJ.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.ACJ.play(localObjectAnimator5).after(localObjectAnimator4);
    this.ACJ.play(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).after(localObjectAnimator5);
    this.ACJ.play(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator11).after(localObjectAnimator8);
    this.ACJ.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(198600);
        ad.i("SnsAdTouchProgressView", "onAnimationEnd, isCanceled=" + SnsAdTouchProgressView.this.mIsCanceled);
        SnsAdTouchProgressView.this.nIL = false;
        if ((SnsAdTouchProgressView.this.zZo != null) && (!SnsAdTouchProgressView.this.mIsCanceled))
        {
          SnsAdTouchProgressView.this.zZo.onFinish();
          SnsAdTouchProgressView.this.ACH = true;
        }
        AppMethodBeat.o(198600);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(179412);
  }
  
  private void hZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179415);
    int i = this.ACE;
    int j = this.ACE;
    int k = paramInt1 - this.ACF;
    int m = paramInt2 - this.ACF;
    this.ACB.leftMargin = (paramInt1 - i);
    this.ACB.topMargin = (paramInt2 - j);
    this.ACC.leftMargin = k;
    this.ACC.topMargin = m;
    this.ACD.leftMargin = k;
    this.ACD.topMargin = m;
    this.mInnerView.setLayoutParams(this.ACB);
    this.ACz.setLayoutParams(this.ACC);
    this.ACA.setLayoutParams(this.ACD);
    AppMethodBeat.o(179415);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.mInnerView = new View(paramContext);
    this.mInnerView.setBackgroundResource(2131234091);
    this.ACz = new View(paramContext);
    this.ACz.setBackgroundResource(2131234092);
    this.ACA = new com.tencent.mm.plugin.sns.ad.f.a.b(paramContext);
    this.ACE = com.tencent.mm.cc.a.fromDPToPix(paramContext, 36);
    this.ACF = com.tencent.mm.cc.a.fromDPToPix(paramContext, 68);
    this.ACG = com.tencent.mm.cc.a.fromDPToPix(paramContext, 6);
    this.ACB = new FrameLayout.LayoutParams(this.ACE * 2, this.ACE * 2);
    this.ACC = new FrameLayout.LayoutParams(this.ACF * 2, this.ACF * 2);
    this.ACD = new FrameLayout.LayoutParams(this.ACF * 2, this.ACF * 2);
    addView(this.ACz, this.ACC);
    addView(this.mInnerView, this.ACB);
    addView(this.ACA, this.ACD);
    hZ(0, 0);
    this.ACz.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.ACA.setVisibility(4);
    RN(this.ACM);
    RL(this.ACM);
    RM(this.ACM);
    this.lsn = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        ad.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.nIL = true;
        SnsAdTouchProgressView.this.ACI = true;
        if (SnsAdTouchProgressView.this.zZo != null) {
          SnsAdTouchProgressView.this.zZo.onStart();
        }
        SnsAdTouchProgressView.this.bzc();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (SnsAdTouchProgressView.this.zZo != null) {
          SnsAdTouchProgressView.this.zZo.onClick(SnsAdTouchProgressView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179401);
        return true;
      }
    });
    this.ACO = new Paint();
    this.ACO.setColor(Color.parseColor("#35FF0000"));
    AppMethodBeat.o(179407);
  }
  
  protected final void bzc()
  {
    AppMethodBeat.i(179414);
    ad.i("SnsAdTouchProgressView", "doOuterAnim");
    this.ACz.setVisibility(0);
    this.ACK.cancel();
    this.ACK.start();
    ad.i("SnsAdTouchProgressView", "doInnerAnim");
    this.mInnerView.setVisibility(0);
    this.ACJ.cancel();
    this.ACJ.start();
    ad.i("SnsAdTouchProgressView", "doCicleAnim");
    this.ACA.setVisibility(0);
    this.ACL.cancel();
    this.ACL.start();
    AppMethodBeat.o(179414);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179409);
    ad.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.ACz.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.ACA.setVisibility(4);
    this.ACK.cancel();
    this.ACJ.cancel();
    this.ACL.cancel();
    this.ACA.clear();
    AppMethodBeat.o(179409);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(198601);
    if ((this.ACP) && (this.ACN != null)) {
      paramCanvas.drawRect(this.ACN, this.ACO);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(198601);
  }
  
  public final boolean isAnimating()
  {
    return this.nIL;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (this.ACN != null) && (!this.ACN.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      ad.w("SnsAdTouchProgressView", "onTouchEvent, x=" + paramMotionEvent.getX() + ", y=" + paramMotionEvent.getY() + ", range=" + this.ACN.toShortString());
      AppMethodBeat.o(179410);
      return false;
    }
    GestureDetector localGestureDetector = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (i == 0)
    {
      this.ACx = paramMotionEvent.getX();
      this.ACy = paramMotionEvent.getY();
      hZ((int)this.ACx, (int)this.ACy);
      this.ACH = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        ad.i("SnsAdTouchProgressView", "onTouchEvent cancel， action=" + i + ", IsLongClicked=" + this.ACI + ", isSuccFinish=" + this.ACH);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.nIL = false;
        if ((!this.ACH) && (this.ACI) && (this.zZo != null)) {
          this.zZo.onCancel();
        }
        this.ACI = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.zZo = parama;
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(179408);
    ad.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.ACM;
    }
    RN(i);
    RL(i);
    RM(i);
    AppMethodBeat.o(179408);
  }
  
  public void setTouchRange(Rect paramRect)
  {
    this.ACN = paramRect;
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