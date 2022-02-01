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
  private ImageView qgw;
  private ValueAnimator qgz;
  private RectView wbU;
  private Rect wbV;
  private int wbW;
  private int wbX;
  
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
  
  private void dnt()
  {
    AppMethodBeat.i(91119);
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.wbW / 2;
    int j = localPoint.y / 2 - this.wbX / 2;
    this.wbV = new Rect(i, j, this.wbW + i, this.wbX + j);
    this.wbU.setRect(this.wbV);
    AppMethodBeat.o(91119);
  }
  
  private void init()
  {
    AppMethodBeat.i(91117);
    this.wbW = getContext().getResources().getDimensionPixelSize(2131166761);
    this.wbX = getContext().getResources().getDimensionPixelSize(2131166760);
    this.wbU = new RectView(getContext());
    addView(this.wbU, new FrameLayout.LayoutParams(-1, -1));
    dnt();
    setWillNotDraw(false);
    this.qgw = new ImageView(getContext());
    addView(this.qgw, new FrameLayout.LayoutParams(this.wbW, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qgw.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.qgw.setLayoutParams(localLayoutParams);
    this.qgw.setBackgroundResource(2131233727);
    this.qgw.setVisibility(8);
    this.qgz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(2600L);
    this.qgz.setInterpolator(new AccelerateDecelerateInterpolator());
    this.qgz.addListener(new AnimatorListenerAdapter()
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
    this.qgz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(-1);
    AppMethodBeat.o(91117);
  }
  
  public final void cjm()
  {
    AppMethodBeat.i(91122);
    if (!this.qgz.isStarted())
    {
      this.qgw.setVisibility(0);
      this.qgz.start();
    }
    AppMethodBeat.o(91122);
  }
  
  public final void cjn()
  {
    AppMethodBeat.i(91123);
    this.qgz.cancel();
    this.qgw.setVisibility(8);
    AppMethodBeat.o(91123);
  }
  
  public final void gT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91118);
    this.wbW = paramInt1;
    this.wbX = paramInt2;
    dnt();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qgw.getLayoutParams();
    localLayoutParams.width = paramInt1;
    this.qgw.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(91118);
  }
  
  public Rect getDecorRect()
  {
    return this.wbV;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(91120);
    super.onDetachedFromWindow();
    if (this.qgz != null) {
      this.qgz.cancel();
    }
    AppMethodBeat.o(91120);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91121);
    if (paramRect != null)
    {
      this.wbW = paramRect.width();
      this.wbX = paramRect.height();
      this.wbV = new Rect(paramRect);
    }
    this.wbU.setRect(this.wbV);
    this.wbU.postInvalidate();
    AppMethodBeat.o(91121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanRectDecorView
 * JD-Core Version:    0.7.0.1
 */