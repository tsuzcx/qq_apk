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
import com.tencent.mm.sdk.platformtools.ad;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int KTR = -16777216;
  private boolean FH;
  private int KTS;
  private boolean KTT;
  private ViewGroup KTU;
  private ImageView KTV;
  private ImageView KTW;
  private ImageView KTX;
  private final Runnable KTY;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.KTS = KTR;
    this.FH = false;
    this.KTT = false;
    this.KTY = new Runnable()
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
    this.KTS = KTR;
    this.FH = false;
    this.KTT = false;
    this.KTY = new Runnable()
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
    ad.i("ThreeDotsLoadingView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    while (i < 3)
    {
      localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void fLL()
  {
    AppMethodBeat.i(131611);
    this.KTV.setImageDrawable(n(this.KTS, 0.5F));
    this.KTW.setImageDrawable(n(this.KTS, 0.4F));
    this.KTX.setImageDrawable(n(this.KTS, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.KTU = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494574, this, true));
    KTR = paramContext.getResources().getColor(2131100018);
    this.KTS = KTR;
    this.KTV = ((ImageView)this.KTU.findViewById(2131301495));
    this.KTW = ((ImageView)this.KTU.findViewById(2131301496));
    this.KTX = ((ImageView)this.KTU.findViewById(2131301497));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, l.a.ThreeDotsLoadingView);
      this.KTS = paramContext.getColor(0, KTR);
      paramContext.recycle();
    }
    fLL();
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
  
  public final void fLJ()
  {
    AppMethodBeat.i(131609);
    if (!t.aC(this))
    {
      this.KTT = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.FH)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.FH = true;
    fLL();
    postDelayed(this.KTY, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void fLK()
  {
    AppMethodBeat.i(131610);
    this.KTT = false;
    if (!this.FH)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.FH = false;
    removeCallbacks(this.KTY);
    if ((this.KTV.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.KTV.getDrawable()).stop();
      ((AnimationDrawable)this.KTW.getDrawable()).stop();
      ((AnimationDrawable)this.KTX.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.KTT)
    {
      this.KTT = false;
      fLJ();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.KTV.setAlpha(paramFloat);
    this.KTW.setAlpha(paramFloat);
    this.KTX.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      fLK();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */