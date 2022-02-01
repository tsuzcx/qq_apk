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
  private RectView CVp;
  private Rect CVq;
  private int CVr;
  private int CVs;
  private ImageView tgP;
  private ValueAnimator tgS;
  
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
  
  private void eSj()
  {
    AppMethodBeat.i(91119);
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.CVr / 2;
    int j = localPoint.y / 2 - this.CVs / 2;
    this.CVq = new Rect(i, j, this.CVr + i, this.CVs + j);
    this.CVp.setRect(this.CVq);
    AppMethodBeat.o(91119);
  }
  
  private void init()
  {
    AppMethodBeat.i(91117);
    this.CVr = getContext().getResources().getDimensionPixelSize(2131166881);
    this.CVs = getContext().getResources().getDimensionPixelSize(2131166880);
    this.CVp = new RectView(getContext());
    addView(this.CVp, new FrameLayout.LayoutParams(-1, -1));
    eSj();
    setWillNotDraw(false);
    this.tgP = new ImageView(getContext());
    addView(this.tgP, new FrameLayout.LayoutParams(this.CVr, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.tgP.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.tgP.setLayoutParams(localLayoutParams);
    this.tgP.setBackgroundResource(2131234544);
    this.tgP.setVisibility(8);
    this.tgS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(2600L);
    this.tgS.setInterpolator(new AccelerateDecelerateInterpolator());
    this.tgS.addListener(new AnimatorListenerAdapter()
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
    this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(-1);
    AppMethodBeat.o(91117);
  }
  
  public final void cWi()
  {
    AppMethodBeat.i(91122);
    if (!this.tgS.isStarted())
    {
      this.tgP.setVisibility(0);
      this.tgS.start();
    }
    AppMethodBeat.o(91122);
  }
  
  public final void cWj()
  {
    AppMethodBeat.i(91123);
    this.tgS.cancel();
    this.tgP.setVisibility(8);
    AppMethodBeat.o(91123);
  }
  
  public Rect getDecorRect()
  {
    return this.CVq;
  }
  
  public final void ij(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91118);
    this.CVr = paramInt1;
    this.CVs = paramInt2;
    eSj();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.tgP.getLayoutParams();
    localLayoutParams.width = paramInt1;
    this.tgP.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(91118);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(91120);
    super.onDetachedFromWindow();
    if (this.tgS != null) {
      this.tgS.cancel();
    }
    AppMethodBeat.o(91120);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91121);
    if (paramRect != null)
    {
      this.CVr = paramRect.width();
      this.CVs = paramRect.height();
      this.CVq = new Rect(paramRect);
    }
    this.CVp.setRect(this.CVq);
    this.CVp.postInvalidate();
    AppMethodBeat.o(91121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanRectDecorView
 * JD-Core Version:    0.7.0.1
 */