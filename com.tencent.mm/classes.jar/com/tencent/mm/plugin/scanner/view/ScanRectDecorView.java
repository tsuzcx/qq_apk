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
import com.tencent.mm.plugin.ak.a.c;
import com.tencent.mm.plugin.ak.a.d;

public class ScanRectDecorView
  extends FrameLayout
{
  private float IWR;
  private RectView JaZ;
  private Rect Jba;
  private int Jbb;
  private int Jbc;
  private ImageView wNf;
  private ValueAnimator wNi;
  
  public ScanRectDecorView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91114);
    this.IWR = 0.0F;
    init();
    AppMethodBeat.o(91114);
  }
  
  public ScanRectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91115);
    this.IWR = 0.0F;
    init();
    AppMethodBeat.o(91115);
  }
  
  public ScanRectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91116);
    this.IWR = 0.0F;
    init();
    AppMethodBeat.o(91116);
  }
  
  private void fFl()
  {
    AppMethodBeat.i(91119);
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.Jbb / 2;
    int j = localPoint.y / 2 - this.Jbc / 2;
    this.Jba = new Rect(i, j, this.Jbb + i, this.Jbc + j);
    this.JaZ.setRect(this.Jba);
    AppMethodBeat.o(91119);
  }
  
  private void init()
  {
    AppMethodBeat.i(91117);
    this.Jbb = getContext().getResources().getDimensionPixelSize(a.c.scan_code_rect_width);
    this.Jbc = getContext().getResources().getDimensionPixelSize(a.c.scan_code_rect_height);
    this.JaZ = new RectView(getContext());
    addView(this.JaZ, new FrameLayout.LayoutParams(-1, -1));
    fFl();
    setWillNotDraw(false);
    this.wNf = new ImageView(getContext());
    addView(this.wNf, new FrameLayout.LayoutParams(this.Jbb, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.wNf.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.wNf.setLayoutParams(localLayoutParams);
    this.wNf.setBackgroundResource(a.d.qrcode_scan_line);
    this.wNf.setVisibility(8);
    this.IWR = 0.1538462F;
    this.wNi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1300L);
    this.wNi.setInterpolator(new AccelerateDecelerateInterpolator());
    this.wNi.addListener(new AnimatorListenerAdapter()
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
    this.wNi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(91113);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        paramAnonymousValueAnimator = (FrameLayout.LayoutParams)ScanRectDecorView.a(ScanRectDecorView.this).getLayoutParams();
        paramAnonymousValueAnimator.topMargin = (ScanRectDecorView.b(ScanRectDecorView.this).getRect().top + (int)((ScanRectDecorView.c(ScanRectDecorView.this) - ScanRectDecorView.a(ScanRectDecorView.this).getHeight()) * f));
        ScanRectDecorView.a(ScanRectDecorView.this).setLayoutParams(paramAnonymousValueAnimator);
        if (f <= ScanRectDecorView.d(ScanRectDecorView.this))
        {
          f = (ScanRectDecorView.d(ScanRectDecorView.this) - f) / ScanRectDecorView.d(ScanRectDecorView.this);
          ScanRectDecorView.a(ScanRectDecorView.this).setAlpha(1.0F - f);
          AppMethodBeat.o(91113);
          return;
        }
        if (f >= 1.0F - ScanRectDecorView.d(ScanRectDecorView.this))
        {
          f = (f - (1.0F - ScanRectDecorView.d(ScanRectDecorView.this))) / ScanRectDecorView.d(ScanRectDecorView.this);
          ScanRectDecorView.a(ScanRectDecorView.this).setAlpha(1.0F - f);
          AppMethodBeat.o(91113);
          return;
        }
        ScanRectDecorView.a(ScanRectDecorView.this).setAlpha(1.0F);
        AppMethodBeat.o(91113);
      }
    });
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(-1);
    AppMethodBeat.o(91117);
  }
  
  public final void dlp()
  {
    AppMethodBeat.i(91122);
    if (!this.wNi.isStarted())
    {
      this.wNf.setVisibility(0);
      this.wNi.start();
    }
    AppMethodBeat.o(91122);
  }
  
  public final void dlq()
  {
    AppMethodBeat.i(91123);
    this.wNi.cancel();
    this.wNf.setVisibility(8);
    AppMethodBeat.o(91123);
  }
  
  public Rect getDecorRect()
  {
    return this.Jba;
  }
  
  public final void jp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91118);
    this.Jbb = paramInt1;
    this.Jbc = paramInt2;
    fFl();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.wNf.getLayoutParams();
    localLayoutParams.width = paramInt1;
    this.wNf.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(91118);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(91120);
    super.onDetachedFromWindow();
    if (this.wNi != null) {
      this.wNi.cancel();
    }
    AppMethodBeat.o(91120);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91121);
    if (paramRect != null)
    {
      this.Jbb = paramRect.width();
      this.Jbc = paramRect.height();
      this.Jba = new Rect(paramRect);
    }
    this.JaZ.setRect(this.Jba);
    this.JaZ.postInvalidate();
    AppMethodBeat.o(91121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanRectDecorView
 * JD-Core Version:    0.7.0.1
 */