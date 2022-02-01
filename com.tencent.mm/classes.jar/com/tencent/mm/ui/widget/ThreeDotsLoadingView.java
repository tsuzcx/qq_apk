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
import com.tencent.mm.sdk.platformtools.ac;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int JcJ = -16777216;
  private boolean DQ;
  private int JcK;
  private boolean JcL;
  private ViewGroup JcM;
  private ImageView JcN;
  private ImageView JcO;
  private ImageView JcP;
  private final Runnable JcQ;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.JcK = JcJ;
    this.DQ = false;
    this.JcL = false;
    this.JcQ = new Runnable()
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
    this.JcK = JcJ;
    this.DQ = false;
    this.JcL = false;
    this.JcQ = new Runnable()
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
    ac.i("ThreeDotsLoadingView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    while (i < 3)
    {
      localAnimationDrawable.addFrame(m(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void fuY()
  {
    AppMethodBeat.i(131611);
    this.JcN.setImageDrawable(m(this.JcK, 0.5F));
    this.JcO.setImageDrawable(m(this.JcK, 0.4F));
    this.JcP.setImageDrawable(m(this.JcK, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.JcM = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494574, this, true));
    JcJ = paramContext.getResources().getColor(2131100018);
    this.JcK = JcJ;
    this.JcN = ((ImageView)this.JcM.findViewById(2131301495));
    this.JcO = ((ImageView)this.JcM.findViewById(2131301496));
    this.JcP = ((ImageView)this.JcM.findViewById(2131301497));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, l.a.ThreeDotsLoadingView);
      this.JcK = paramContext.getColor(0, JcJ);
      paramContext.recycle();
    }
    fuY();
    AppMethodBeat.o(131605);
  }
  
  private static Drawable m(int paramInt, float paramFloat)
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
  
  public final void fuW()
  {
    AppMethodBeat.i(131609);
    if (!t.aC(this))
    {
      this.JcL = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.DQ)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.DQ = true;
    fuY();
    postDelayed(this.JcQ, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void fuX()
  {
    AppMethodBeat.i(131610);
    this.JcL = false;
    if (!this.DQ)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.DQ = false;
    removeCallbacks(this.JcQ);
    if ((this.JcN.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.JcN.getDrawable()).stop();
      ((AnimationDrawable)this.JcO.getDrawable()).stop();
      ((AnimationDrawable)this.JcP.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.JcL)
    {
      this.JcL = false;
      fuW();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.JcN.setAlpha(paramFloat);
    this.JcO.setAlpha(paramFloat);
    this.JcP.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      fuX();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */