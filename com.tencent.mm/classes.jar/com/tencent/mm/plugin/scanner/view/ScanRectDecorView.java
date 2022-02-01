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
import com.tencent.mm.plugin.al.a.c;
import com.tencent.mm.plugin.al.a.d;

public class ScanRectDecorView
  extends FrameLayout
{
  private ImageView AjC;
  private ValueAnimator AjF;
  private float Pfx;
  private RectView PkS;
  private Rect PkT;
  private int PkU;
  private int PkV;
  
  public ScanRectDecorView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91114);
    this.Pfx = 0.0F;
    init();
    AppMethodBeat.o(91114);
  }
  
  public ScanRectDecorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91115);
    this.Pfx = 0.0F;
    init();
    AppMethodBeat.o(91115);
  }
  
  public ScanRectDecorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91116);
    this.Pfx = 0.0F;
    init();
    AppMethodBeat.o(91116);
  }
  
  private void gUt()
  {
    AppMethodBeat.i(91119);
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = localPoint.x / 2 - this.PkU / 2;
    int j = localPoint.y / 2 - this.PkV / 2;
    this.PkT = new Rect(i, j, this.PkU + i, this.PkV + j);
    this.PkS.setRect(this.PkT);
    AppMethodBeat.o(91119);
  }
  
  private void init()
  {
    AppMethodBeat.i(91117);
    this.PkU = getContext().getResources().getDimensionPixelSize(a.c.scan_code_rect_width);
    this.PkV = getContext().getResources().getDimensionPixelSize(a.c.scan_code_rect_height);
    this.PkS = new RectView(getContext());
    addView(this.PkS, new FrameLayout.LayoutParams(-1, -1));
    gUt();
    setWillNotDraw(false);
    this.AjC = new ImageView(getContext());
    addView(this.AjC, new FrameLayout.LayoutParams(this.PkU, -2));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AjC.getLayoutParams();
    localLayoutParams.gravity = 1;
    this.AjC.setLayoutParams(localLayoutParams);
    this.AjC.setBackgroundResource(a.d.qrcode_scan_line);
    this.AjC.setVisibility(8);
    this.Pfx = 0.1538462F;
    this.AjF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(1300L);
    this.AjF.setInterpolator(new AccelerateDecelerateInterpolator());
    this.AjF.addListener(new AnimatorListenerAdapter()
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
    this.AjF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    AppMethodBeat.o(91117);
  }
  
  public final void dSf()
  {
    AppMethodBeat.i(91122);
    if (!this.AjF.isStarted())
    {
      this.AjC.setVisibility(0);
      this.AjF.start();
    }
    AppMethodBeat.o(91122);
  }
  
  public final void dSg()
  {
    AppMethodBeat.i(91123);
    this.AjF.cancel();
    this.AjC.setVisibility(8);
    AppMethodBeat.o(91123);
  }
  
  public Rect getDecorRect()
  {
    return this.PkT;
  }
  
  public final void kX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91118);
    this.PkU = paramInt1;
    this.PkV = paramInt2;
    gUt();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.AjC.getLayoutParams();
    localLayoutParams.width = paramInt1;
    this.AjC.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(91118);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(91120);
    super.onDetachedFromWindow();
    if (this.AjF != null) {
      this.AjF.cancel();
    }
    AppMethodBeat.o(91120);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(91121);
    if (paramRect != null)
    {
      this.PkU = paramRect.width();
      this.PkV = paramRect.height();
      this.PkT = new Rect(paramRect);
    }
    this.PkS.setRect(this.PkT);
    this.PkS.postInvalidate();
    AppMethodBeat.o(91121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanRectDecorView
 * JD-Core Version:    0.7.0.1
 */