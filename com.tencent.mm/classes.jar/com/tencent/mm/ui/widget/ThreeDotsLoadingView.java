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
  private static int HCn = -16777216;
  private boolean CS;
  private int HCo;
  private boolean HCp;
  private ViewGroup HCq;
  private ImageView HCr;
  private ImageView HCs;
  private ImageView HCt;
  private final Runnable HCu;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.HCo = HCn;
    this.CS = false;
    this.HCp = false;
    this.HCu = new Runnable()
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
    this.HCo = HCn;
    this.CS = false;
    this.HCp = false;
    this.HCu = new Runnable()
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
      localAnimationDrawable.addFrame(m(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void ffd()
  {
    AppMethodBeat.i(131611);
    this.HCr.setImageDrawable(m(this.HCo, 0.5F));
    this.HCs.setImageDrawable(m(this.HCo, 0.4F));
    this.HCt.setImageDrawable(m(this.HCo, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.HCq = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494574, this, true));
    HCn = paramContext.getResources().getColor(2131100018);
    this.HCo = HCn;
    this.HCr = ((ImageView)this.HCq.findViewById(2131301495));
    this.HCs = ((ImageView)this.HCq.findViewById(2131301496));
    this.HCt = ((ImageView)this.HCq.findViewById(2131301497));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, l.a.ThreeDotsLoadingView);
      this.HCo = paramContext.getColor(0, HCn);
      paramContext.recycle();
    }
    ffd();
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
  
  public final void ffb()
  {
    AppMethodBeat.i(131609);
    if (!t.aC(this))
    {
      this.HCp = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.CS)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.CS = true;
    ffd();
    postDelayed(this.HCu, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void ffc()
  {
    AppMethodBeat.i(131610);
    this.HCp = false;
    if (!this.CS)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.CS = false;
    removeCallbacks(this.HCu);
    if ((this.HCr.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.HCr.getDrawable()).stop();
      ((AnimationDrawable)this.HCs.getDrawable()).stop();
      ((AnimationDrawable)this.HCt.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.HCp)
    {
      this.HCp = false;
      ffb();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.HCr.setAlpha(paramFloat);
    this.HCs.setAlpha(paramFloat);
    this.HCt.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      ffc();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */