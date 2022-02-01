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
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected a EzA;
  protected float FeE;
  protected float FeF;
  protected View FeG;
  protected com.tencent.mm.plugin.sns.ad.widget.a.b FeH;
  protected FrameLayout.LayoutParams FeI;
  protected FrameLayout.LayoutParams FeJ;
  protected FrameLayout.LayoutParams FeK;
  protected int FeL;
  protected int FeM;
  protected int FeN;
  protected boolean FeO;
  protected boolean FeP;
  protected AnimatorSet FeQ;
  protected AnimatorSet FeR;
  protected AnimatorSet FeS;
  protected int FeT;
  protected Rect FeU;
  protected Paint FeV;
  protected boolean FeW;
  protected Context mContext;
  protected GestureDetector mDJ;
  protected View mInnerView;
  protected boolean mIsCanceled;
  protected boolean nmN;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.FeE = 0.0F;
    this.FeF = 0.0F;
    this.FeO = false;
    this.nmN = false;
    this.mIsCanceled = false;
    this.FeP = false;
    this.FeT = 4000;
    this.FeW = false;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.FeE = 0.0F;
    this.FeF = 0.0F;
    this.FeO = false;
    this.nmN = false;
    this.mIsCanceled = false;
    this.FeP = false;
    this.FeT = 4000;
    this.FeW = false;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void aao(int paramInt)
  {
    AppMethodBeat.i(179411);
    int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.FeG, "scaleX", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(i);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.FeG, "scaleY", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    localObjectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.FeG, "alpha", new float[] { 0.0F, 0.4F });
    localObjectAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
    localObjectAnimator3.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.FeG, "alpha", new float[] { 0.4F, 0.4F });
    localObjectAnimator4.setDuration(i);
    i = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.FeG, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(i);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.FeG, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(i);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.FeG, "alpha", new float[] { 0.4F, 0.2F });
    localObjectAnimator7.setDuration(i);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.FeG, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.FeG, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.FeG, "alpha", new float[] { 0.2F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.FeR = new AnimatorSet();
    this.FeR.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    this.FeR.play(localObjectAnimator4).after(localObjectAnimator1);
    this.FeR.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.FeR.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator5);
    AppMethodBeat.o(179411);
  }
  
  private void aap(int paramInt)
  {
    AppMethodBeat.i(203994);
    final int i = (int)(0.1D * paramInt);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.FeH, "alpha", new float[] { 0.0F, 0.0F });
    localObjectAnimator1.setDuration(i);
    i = (int)(0.8D * paramInt);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.FeH, "scaleX", new float[] { 1.0F, 1.0F });
    localObjectAnimator2.setDuration(i);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.FeH, "scaleY", new float[] { 1.0F, 1.0F });
    localObjectAnimator3.setDuration(i);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.FeH, "alpha", new float[] { 1.0F, 1.0F });
    localObjectAnimator4.setDuration(i);
    int j = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.FeH, "scaleX", new float[] { 1.0F, 0.823F });
    localObjectAnimator5.setDuration(j);
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this.FeH, "scaleY", new float[] { 1.0F, 0.823F });
    localObjectAnimator6.setDuration(j);
    ObjectAnimator localObjectAnimator7 = ObjectAnimator.ofFloat(this.FeH, "alpha", new float[] { 1.0F, 0.4F });
    localObjectAnimator7.setDuration(j);
    paramInt = (int)(0.05D * paramInt);
    ObjectAnimator localObjectAnimator8 = ObjectAnimator.ofFloat(this.FeH, "scaleX", new float[] { 0.823F, 1.235F });
    localObjectAnimator8.setDuration(paramInt);
    ObjectAnimator localObjectAnimator9 = ObjectAnimator.ofFloat(this.FeH, "scaleY", new float[] { 0.823F, 1.235F });
    localObjectAnimator9.setDuration(paramInt);
    ObjectAnimator localObjectAnimator10 = ObjectAnimator.ofFloat(this.FeH, "alpha", new float[] { 0.4F, 0.0F });
    localObjectAnimator10.setDuration(paramInt);
    this.FeS = new AnimatorSet();
    this.FeS.play(localObjectAnimator1);
    this.FeS.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.FeS.play(localObjectAnimator5).with(localObjectAnimator6).with(localObjectAnimator7).after(localObjectAnimator4);
    this.FeS.play(localObjectAnimator8).with(localObjectAnimator9).with(localObjectAnimator10).after(localObjectAnimator7);
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
        AppMethodBeat.i(203991);
        Log.i("SnsAdTouchProgressView", "a1 onAnimationStart, startProgress, duration=" + i);
        SnsAdTouchProgressView.this.FeH.ax(i, SnsAdTouchProgressView.this.FeM, SnsAdTouchProgressView.this.FeN);
        AppMethodBeat.o(203991);
      }
    });
    AppMethodBeat.o(203994);
  }
  
  private void aaq(int paramInt)
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
    this.FeQ = new AnimatorSet();
    this.FeQ.play(localObjectAnimator1);
    this.FeQ.play(localObjectAnimator2).with(localObjectAnimator3).with(localObjectAnimator4).after(localObjectAnimator1);
    this.FeQ.play(localObjectAnimator5).after(localObjectAnimator4);
    this.FeQ.play(localObjectAnimator6).with(localObjectAnimator7).with(localObjectAnimator8).after(localObjectAnimator5);
    this.FeQ.play(localObjectAnimator9).with(localObjectAnimator10).with(localObjectAnimator11).after(localObjectAnimator8);
    this.FeQ.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(203992);
        Log.i("SnsAdTouchProgressView", "onAnimationEnd, isCanceled=" + SnsAdTouchProgressView.this.mIsCanceled);
        SnsAdTouchProgressView.this.nmN = false;
        if ((SnsAdTouchProgressView.this.EzA != null) && (!SnsAdTouchProgressView.this.mIsCanceled))
        {
          SnsAdTouchProgressView.this.EzA.onFinish();
          SnsAdTouchProgressView.this.FeO = true;
        }
        AppMethodBeat.o(203992);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(179412);
  }
  
  private void iX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(179415);
    int i = this.FeL;
    int j = this.FeL;
    int k = paramInt1 - this.FeM;
    int m = paramInt2 - this.FeM;
    this.FeI.leftMargin = (paramInt1 - i);
    this.FeI.topMargin = (paramInt2 - j);
    this.FeJ.leftMargin = k;
    this.FeJ.topMargin = m;
    this.FeK.leftMargin = k;
    this.FeK.topMargin = m;
    this.mInnerView.setLayoutParams(this.FeI);
    this.FeG.setLayoutParams(this.FeJ);
    this.FeH.setLayoutParams(this.FeK);
    AppMethodBeat.o(179415);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.mInnerView = new View(paramContext);
    this.mInnerView.setBackgroundResource(2131234948);
    this.FeG = new View(paramContext);
    this.FeG.setBackgroundResource(2131234949);
    this.FeH = new com.tencent.mm.plugin.sns.ad.widget.a.b(paramContext);
    this.FeL = com.tencent.mm.cb.a.fromDPToPix(paramContext, 36);
    this.FeM = com.tencent.mm.cb.a.fromDPToPix(paramContext, 68);
    this.FeN = com.tencent.mm.cb.a.fromDPToPix(paramContext, 6);
    this.FeI = new FrameLayout.LayoutParams(this.FeL * 2, this.FeL * 2);
    this.FeJ = new FrameLayout.LayoutParams(this.FeM * 2, this.FeM * 2);
    this.FeK = new FrameLayout.LayoutParams(this.FeM * 2, this.FeM * 2);
    addView(this.FeG, this.FeJ);
    addView(this.mInnerView, this.FeI);
    addView(this.FeH, this.FeK);
    iX(0, 0);
    this.FeG.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.FeH.setVisibility(4);
    aaq(this.FeT);
    aao(this.FeT);
    aap(this.FeT);
    this.mDJ = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        Log.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.nmN = true;
        SnsAdTouchProgressView.this.FeP = true;
        if (SnsAdTouchProgressView.this.EzA != null) {
          SnsAdTouchProgressView.this.EzA.onStart();
        }
        SnsAdTouchProgressView.this.bWT();
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if (SnsAdTouchProgressView.this.EzA != null) {
          SnsAdTouchProgressView.this.EzA.onClick(SnsAdTouchProgressView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179401);
        return true;
      }
    });
    this.FeV = new Paint();
    this.FeV.setColor(Color.parseColor("#35FF0000"));
    AppMethodBeat.o(179407);
  }
  
  protected final void bWT()
  {
    AppMethodBeat.i(179414);
    Log.i("SnsAdTouchProgressView", "doOuterAnim");
    this.FeG.setVisibility(0);
    this.FeR.cancel();
    this.FeR.start();
    Log.i("SnsAdTouchProgressView", "doInnerAnim");
    this.mInnerView.setVisibility(0);
    this.FeQ.cancel();
    this.FeQ.start();
    Log.i("SnsAdTouchProgressView", "doCicleAnim");
    this.FeH.setVisibility(0);
    this.FeS.cancel();
    this.FeS.start();
    AppMethodBeat.o(179414);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179409);
    Log.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.FeG.setVisibility(4);
    this.mInnerView.setVisibility(4);
    this.FeH.setVisibility(4);
    this.FeR.cancel();
    this.FeQ.cancel();
    this.FeS.cancel();
    this.FeH.clear();
    AppMethodBeat.o(179409);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(203993);
    if ((this.FeW) && (this.FeU != null)) {
      paramCanvas.drawRect(this.FeU, this.FeV);
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(203993);
  }
  
  public final boolean isAnimating()
  {
    return this.nmN;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    if ((i == 0) && (this.FeU != null) && (!this.FeU.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      Log.w("SnsAdTouchProgressView", "onTouchEvent, x=" + paramMotionEvent.getX() + ", y=" + paramMotionEvent.getY() + ", range=" + this.FeU.toShortString());
      AppMethodBeat.o(179410);
      return false;
    }
    GestureDetector localGestureDetector = this.mDJ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (i == 0)
    {
      this.FeE = paramMotionEvent.getX();
      this.FeF = paramMotionEvent.getY();
      iX((int)this.FeE, (int)this.FeF);
      this.FeO = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        Log.i("SnsAdTouchProgressView", "onTouchEvent cancel， action=" + i + ", IsLongClicked=" + this.FeP + ", isSuccFinish=" + this.FeO);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.nmN = false;
        if ((!this.FeO) && (this.FeP) && (this.EzA != null)) {
          this.EzA.onCancel();
        }
        this.FeP = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.EzA = parama;
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(179408);
    Log.i("SnsAdTouchProgressView", "setDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt <= 0) {
      i = this.FeT;
    }
    aaq(i);
    aao(i);
    aap(i);
    AppMethodBeat.o(179408);
  }
  
  public void setTouchRange(Rect paramRect)
  {
    this.FeU = paramRect;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onClick(View paramView);
    
    public abstract void onFinish();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView
 * JD-Core Version:    0.7.0.1
 */