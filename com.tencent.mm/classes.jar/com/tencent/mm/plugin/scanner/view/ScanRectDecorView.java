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
  private ImageView qOY;
  private ValueAnimator qPb;
  private RectView xnb;
  private Rect xnc;
  private int xnd;
  private int xne;
  
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
  
  private void dBB()
  {
    AppMethodBeat.i(91119);
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.xnd / 2;
    int j = localPoint.y / 2 - this.xne / 2;
    this.xnc = new Rect(i, j, this.xnd + i, this.xne + j);
    this.xnb.setRect(this.xnc);
    AppMethodBeat.o(91119);
  }
  
  private void init()
  {
    AppMethodBeat.i(91117);
    this.xnd = getContext().getResources().getDimensionPixelSize(2131166761);
    this.xne = getContext().getResources().getDimensionPixelSize(2131166760);
    this.xnb = new RectView(getContext());
    addView(this.xnb, new FrameLayout.LayoutParams(-1, -1));
    dBB();
    setWillNotDraw(false);
    this.qOY = new ImageView(getContext());
    addView(this.qOY, new FrameLayout.LayoutParams(this.xnd, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qOY.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.qOY.setLayoutParams(localLayoutParams);
    this.qOY.setBackgroundResource(2131233727);
    this.qOY.setVisibility(8);
    this.qPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(2600L);
    this.qPb.setInterpolator(new AccelerateDecelerateInterpolator());
    this.qPb.addListener(new AnimatorListenerAdapter()
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
    this.qPb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(-1);
    AppMethodBeat.o(91117);
  }
  
  public final void cqT()
  {
    AppMethodBeat.i(91122);
    if (!this.qPb.isStarted())
    {
      this.qOY.setVisibility(0);
      this.qPb.start();
    }
    AppMethodBeat.o(91122);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(91123);
    this.qPb.cancel();
    this.qOY.setVisibility(8);
    AppMethodBeat.o(91123);
  }
  
  public Rect getDecorRect()
  {
    return this.xnc;
  }
  
  public final void hc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91118);
    this.xnd = paramInt1;
    this.xne = paramInt2;
    dBB();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qOY.getLayoutParams();
    localLayoutParams.width = paramInt1;
    this.qOY.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(91118);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(91120);
    super.onDetachedFromWindow();
    if (this.qPb != null) {
      this.qPb.cancel();
    }
    AppMethodBeat.o(91120);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91121);
    if (paramRect != null)
    {
      this.xnd = paramRect.width();
      this.xne = paramRect.height();
      this.xnc = new Rect(paramRect);
    }
    this.xnb.setRect(this.xnc);
    this.xnb.postInvalidate();
    AppMethodBeat.o(91121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanRectDecorView
 * JD-Core Version:    0.7.0.1
 */