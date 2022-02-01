package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanRectDecorView
  extends FrameLayout
{
  private ImageView ryX;
  private ValueAnimator rza;
  private RectView yBc;
  private Rect yBd;
  private int yBe;
  private int yBf;
  
  public ScanRectDecorView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91114);
    init();
    AppMethodBeat.o(91114);
  }
  
  public ScanRectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91115);
    init();
    AppMethodBeat.o(91115);
  }
  
  public ScanRectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91116);
    init();
    AppMethodBeat.o(91116);
  }
  
  private void dMY()
  {
    AppMethodBeat.i(91119);
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.yBe / 2;
    int j = localPoint.y / 2 - this.yBf / 2;
    this.yBd = new Rect(i, j, this.yBe + i, this.yBf + j);
    this.yBc.setRect(this.yBd);
    AppMethodBeat.o(91119);
  }
  
  private void init()
  {
    AppMethodBeat.i(91117);
    this.yBe = getContext().getResources().getDimensionPixelSize(2131166761);
    this.yBf = getContext().getResources().getDimensionPixelSize(2131166760);
    this.yBc = new RectView(getContext());
    addView(this.yBc, new FrameLayout.LayoutParams(-1, -1));
    dMY();
    setWillNotDraw(false);
    this.ryX = new ImageView(getContext());
    addView(this.ryX, new FrameLayout.LayoutParams(this.yBe, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ryX.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.ryX.setLayoutParams(localLayoutParams);
    this.ryX.setBackgroundResource(2131233727);
    this.ryX.setVisibility(8);
    this.rza = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(2600L);
    this.rza.setInterpolator(new AccelerateDecelerateInterpolator());
    this.rza.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(91111);
        ScanRectDecorView.a(ScanRectDecorView.this).setVisibility(8);
        AppMethodBeat.o(91111);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(91112);
        paramAnonymousAnimator = (FrameLayout.LayoutParams)ScanRectDecorView.a(ScanRectDecorView.this).getLayoutParams();
        paramAnonymousAnimator.topMargin = ScanRectDecorView.b(ScanRectDecorView.this).getRect().top;
        ScanRectDecorView.a(ScanRectDecorView.this).setLayoutParams(paramAnonymousAnimator);
        ScanRectDecorView.a(ScanRectDecorView.this).setVisibility(0);
        AppMethodBeat.o(91112);
      }
    });
    this.rza.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(91113);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (FrameLayout.LayoutParams)ScanRectDecorView.a(ScanRectDecorView.this).getLayoutParams();
        int i = ScanRectDecorView.b(ScanRectDecorView.this).getRect().top;
        paramAnonymousValueAnimator.topMargin = ((int)(f * (ScanRectDecorView.c(ScanRectDecorView.this) - ScanRectDecorView.a(ScanRectDecorView.this).getHeight())) + i);
        ScanRectDecorView.a(ScanRectDecorView.this).setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(91113);
      }
    });
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(-1);
    AppMethodBeat.o(91117);
  }
  
  public final void cwD()
  {
    AppMethodBeat.i(91122);
    if (!this.rza.isStarted())
    {
      this.ryX.setVisibility(0);
      this.rza.start();
    }
    AppMethodBeat.o(91122);
  }
  
  public final void cwE()
  {
    AppMethodBeat.i(91123);
    this.rza.cancel();
    this.ryX.setVisibility(8);
    AppMethodBeat.o(91123);
  }
  
  public Rect getDecorRect()
  {
    return this.yBd;
  }
  
  public final void ht(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91118);
    this.yBe = paramInt1;
    this.yBf = paramInt2;
    dMY();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ryX.getLayoutParams();
    localLayoutParams.width = paramInt1;
    this.ryX.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(91118);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(91120);
    super.onDetachedFromWindow();
    if (this.rza != null) {
      this.rza.cancel();
    }
    AppMethodBeat.o(91120);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91121);
    if (paramRect != null)
    {
      this.yBe = paramRect.width();
      this.yBf = paramRect.height();
      this.yBd = new Rect(paramRect);
    }
    this.yBc.setRect(this.yBd);
    this.yBc.postInvalidate();
    AppMethodBeat.o(91121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanRectDecorView
 * JD-Core Version:    0.7.0.1
 */