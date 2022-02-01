package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.l.a;
import com.tencent.mm.sdk.platformtools.ae;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int Lqp = -16777216;
  private boolean FH;
  private int Lqq;
  private boolean Lqr;
  private ViewGroup Lqs;
  private ImageView Lqt;
  private ImageView Lqu;
  private ImageView Lqv;
  private final Runnable Lqw;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.Lqq = Lqp;
    this.FH = false;
    this.Lqr = false;
    this.Lqw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131602);
        ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
        ((AnimationDrawable)ThreeDotsLoadingView.b(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.c(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.d(ThreeDotsLoadingView.this).getDrawable()).start();
        AppMethodBeat.o(131602);
      }
    };
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(131603);
  }
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(131604);
    this.Lqq = Lqp;
    this.FH = false;
    this.Lqr = false;
    this.Lqw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131602);
        ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
        ((AnimationDrawable)ThreeDotsLoadingView.b(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.c(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.d(ThreeDotsLoadingView.this).getDrawable()).start();
        AppMethodBeat.o(131602);
      }
    };
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(131604);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    int i = 0;
    AppMethodBeat.i(131612);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    ae.i("ThreeDotsLoadingView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    while (i < 3)
    {
      localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void fQf()
  {
    AppMethodBeat.i(131611);
    this.Lqt.setImageDrawable(n(this.Lqq, 0.5F));
    this.Lqu.setImageDrawable(n(this.Lqq, 0.4F));
    this.Lqv.setImageDrawable(n(this.Lqq, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.Lqs = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494574, this, true));
    Lqp = paramContext.getResources().getColor(2131100018);
    this.Lqq = Lqp;
    this.Lqt = ((ImageView)this.Lqs.findViewById(2131301495));
    this.Lqu = ((ImageView)this.Lqs.findViewById(2131301496));
    this.Lqv = ((ImageView)this.Lqs.findViewById(2131301497));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, l.a.ThreeDotsLoadingView);
      this.Lqq = paramContext.getColor(0, Lqp);
      paramContext.recycle();
    }
    fQf();
    AppMethodBeat.o(131605);
  }
  
  private static Drawable n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(131613);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    AppMethodBeat.o(131613);
    return localShapeDrawable;
  }
  
  public final void fQd()
  {
    AppMethodBeat.i(131609);
    if (!t.aC(this))
    {
      this.Lqr = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.FH)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.FH = true;
    fQf();
    postDelayed(this.Lqw, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void fQe()
  {
    AppMethodBeat.i(131610);
    this.Lqr = false;
    if (!this.FH)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.FH = false;
    removeCallbacks(this.Lqw);
    if ((this.Lqt.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.Lqt.getDrawable()).stop();
      ((AnimationDrawable)this.Lqu.getDrawable()).stop();
      ((AnimationDrawable)this.Lqv.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.Lqr)
    {
      this.Lqr = false;
      fQd();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.Lqt.setAlpha(paramFloat);
    this.Lqu.setAlpha(paramFloat);
    this.Lqv.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      fQe();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */