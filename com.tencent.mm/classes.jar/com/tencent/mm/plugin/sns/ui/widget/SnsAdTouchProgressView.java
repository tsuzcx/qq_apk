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
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected a KNp;
  protected Paint LtA;
  protected boolean LtB;
  protected float Ltj;
  protected float Ltk;
  protected View Ltl;
  protected com.tencent.mm.plugin.sns.ad.widget.a.b Ltm;
  protected FrameLayout.LayoutParams Ltn;
  protected FrameLayout.LayoutParams Lto;
  protected FrameLayout.LayoutParams Ltp;
  protected int Ltq;
  protected int Ltr;
  protected int Lts;
  protected boolean Ltt;
  protected boolean Ltu;
  protected AnimatorSet Ltv;
  protected AnimatorSet Ltw;
  protected AnimatorSet Ltx;
  protected int Lty;
  protected Rect Ltz;
  protected Context mContext;
  protected View mInnerView;
  protected boolean mIsCanceled;
  protected GestureDetector pCU;
  protected boolean qov;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.Ltj = 0.0F;
    this.Ltk = 0.0F;
    this.Ltt = false;
    this.qov = false;
    this.mIsCanceled = false;
    this.Ltu = false;
    this.Lty = 4000;
    this.LtB = false;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.Ltj = 0.0F;
    this.Ltk = 0.0F;
    this.Ltt = false;
    this.qov = false;
    this.mIsCanceled = false;
    this.Ltu = false;
    this.Lty = 4000;
    this.LtB = false;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void ahI(int paramInt)
  {
    AppMethodBeat.i(179411);
    int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Ltl, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(i);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Ltl, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Ltl, "alpha", new float[] { 0.0F, 0.4F });
    localObjectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator3.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.Ltl, "alpha", new float[] { 0.4F, 0.4F });
    localObjectAnimator4.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.Ltl, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(i);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.Ltl, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.Ltl, "alpha", new float[] { 0.4F, 0.2F });
    localObjectAnimator7.setDuration(i);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.Ltl, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.Ltl, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.Ltl, "alpha", new float[] { 0.2F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.Ltw = new AnimatorSet();
    this.Ltw.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.Ltw.play(localObjectAnimator4).after(localObjectAnimator1);
    this.Ltw.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.Ltw.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator5);
    AppMethodBeat.o(179411);
  }
  
  private void ahJ(int paramInt)
  {
    AppMethodBeat.i(261115);
    final int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Ltm, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Ltm, "scaleX", new float[] { 1.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.Ltm, "scaleY", new float[] { 1.0F, 1.0F });
    localObjectAnimator3.setDuration(i);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.Ltm, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator4.setDuration(i);
    int j = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.Ltm, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(j);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.Ltm, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(j);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.Ltm, "alpha", new float[] { 1.0F, 0.4F });
    localObjectAnimator7.setDuration(j);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.Ltm, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.Ltm, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.Ltm, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.Ltx = new AnimatorSet();
    this.Ltx.play(localObjectAnimator1);
    this.Ltx.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.Ltx.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.Ltx.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator7);
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
        AppMethodBeat.i(218143);
        Log.i("SnsAdTouchProgressView", "a1 onAnimationStart, startProgress, duration=" + i);
        SnsAdTouchProgressView.this.Ltm.aB(i, SnsAdTouchProgressView.this.Ltr, SnsAdTouchProgressView.this.Lts);
        AppMethodBeat.o(218143);
      }
    });
    AppMethodBeat.o(261115);
  }
  
  private void ahK(int paramInt)
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
    this.Ltv = new AnimatorSet();
    this.Ltv.play(localObjectAnimator1);
    this.Ltv.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.Ltv.play(localObjectAnimator5).after(localObjectAnimator4);
    this.Ltv.play(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).after(localObjectAnimator5);
    this.Ltv.play(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator11).after(localObjectAnimator8);
    this.Ltv.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(237431);
        Log.i("SnsAdTouchProgressView", "onAnimationEnd, isCanceled=" + SnsAdTouchProgressView.this.mIsCanceled);
        SnsAdTouchProgressView.this.qov = false;
        if ((SnsAdTouchProgressView.this.KNp != null) && (!SnsAdTouchProgressView.this.mIsCanceled))
        {
          SnsAdTouchProgressView.this.KNp.onFinish();
          SnsAdTouchProgressView.this.Ltt = true;
        }
        AppMethodBeat.o(237431);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(179412);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.mInnerView = new View(paramContext);
    this.mInnerView.setBackgroundResource(i.e.sns_ad_longpress_inner_bg);
    this.Ltl = new View(paramContext);
    this.Ltl.setBackgroundResource(i.e.sns_ad_longpress_outer_bg);
    this.Ltm = new com.tencent.mm.plugin.sns.ad.widget.a.b(paramContext);
    this.Ltq = com.tencent.mm.ci.a.fromDPToPix(paramContext, 36);
    this.Ltr = com.tencent.mm.ci.a.fromDPToPix(paramContext, 68);
    this.Lts = com.tencent.mm.ci.a.fromDPToPix(paramContext, 6);
    this.Ltn = new FrameLayout.LayoutParams(this.Ltq * 2, this.Ltq * 2);
    this.Lto = new FrameLayout.LayoutParams(this.Ltr * 2, this.Ltr * 2);
    this.Ltp = new FrameLayout.LayoutParams(this.Ltr * 2, this.Ltr * 2);
    addView(this.Ltl, this.Lto);
    addView(this.mInnerView, this.Ltn);
    addView(this.Ltm, this.Ltp);
    kh(0, 0);
    this.Ltl.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.Ltm.setVisibility(4);
    ahK(this.Lty);
    ahI(this.Lty);
    ahJ(this.Lty);
    this.pCU = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
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
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        Log.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.qov = true;
        SnsAdTouchProgressView.this.Ltu = true;
        if (SnsAdTouchProgressView.this.KNp != null) {
          SnsAdTouchProgressView.this.KNp.onStart();
        }
        SnsAdTouchProgressView.this.cjx();
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
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        if (SnsAdTouchProgressView.this.KNp != null) {
          SnsAdTouchProgressView.this.KNp.onClick(SnsAdTouchProgressView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179401);
        return true;
      }
    });
    this.LtA = new Paint();
    this.LtA.setColor(Color.parseColor("#35FF0000"));
    AppMethodBeat.o(179407);
  }
  
  private void kh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179415);
    int i = this.Ltq;
    int j = this.Ltq;
    int k = paramInt1 - this.Ltr;
    int m = paramInt2 - this.Ltr;
    this.Ltn.leftMargin = (paramInt1 - i);
    this.Ltn.topMargin = (paramInt2 - j);
    this.Lto.leftMargin = k;
    this.Lto.topMargin = m;
    this.Ltp.leftMargin = k;
    this.Ltp.topMargin = m;
    this.mInnerView.setLayoutParams(this.Ltn);
    this.Ltl.setLayoutParams(this.Lto);
    this.Ltm.setLayoutParams(this.Ltp);
    AppMethodBeat.o(179415);
  }
  
  protected final void cjx()
  {
    AppMethodBeat.i(179414);
    Log.i("SnsAdTouchProgressView", "doOuterAnim");
    this.Ltl.setVisibility(0);
    this.Ltw.cancel();
    this.Ltw.start();
    Log.i("SnsAdTouchProgressView", "doInnerAnim");
    this.mInnerView.setVisibility(0);
    this.Ltv.cancel();
    this.Ltv.start();
    Log.i("SnsAdTouchProgressView", "doCicleAnim");
    this.Ltm.setVisibility(0);
    this.Ltx.cancel();
    this.Ltx.start();
    AppMethodBeat.o(179414);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179409);
    Log.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.Ltl.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.Ltm.setVisibility(4);
    this.Ltw.cancel();
    this.Ltv.cancel();
    this.Ltx.cancel();
    this.Ltm.clear();
    AppMethodBeat.o(179409);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(261106);
    if ((this.LtB) && (this.Ltz != null)) {
      paramCanvas.drawRect(this.Ltz, this.LtA);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(261106);
  }
  
  public final boolean fEq()
  {
    return this.qov;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (this.Ltz != null) && (!this.Ltz.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      Log.w("SnsAdTouchProgressView", "onTouchEvent, x=" + paramMotionEvent.getX() + ", y=" + paramMotionEvent.getY() + ", range=" + this.Ltz.toShortString());
      AppMethodBeat.o(179410);
      return false;
    }
    GestureDetector localGestureDetector = this.pCU;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (i == 0)
    {
      this.Ltj = paramMotionEvent.getX();
      this.Ltk = paramMotionEvent.getY();
      kh((int)this.Ltj, (int)this.Ltk);
      this.Ltt = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        Log.i("SnsAdTouchProgressView", "onTouchEvent cancel， action=" + i + ", IsLongClicked=" + this.Ltu + ", isSuccFinish=" + this.Ltt);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.qov = false;
        if ((!this.Ltt) && (this.Ltu) && (this.KNp != null)) {
          this.KNp.onCancel();
        }
        this.Ltu = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.KNp = parama;
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(179408);
    Log.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.Lty;
    }
    ahK(i);
    ahI(i);
    ahJ(i);
    AppMethodBeat.o(179408);
  }
  
  public void setTouchRange(Rect paramRect)
  {
    this.Ltz = paramRect;
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