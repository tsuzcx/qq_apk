package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.q.b;
import com.tencent.mm.plugin.appbrand.widget.q.c;
import com.tencent.mm.plugin.appbrand.widget.q.d;
import com.tencent.mm.plugin.appbrand.widget.q.e;
import com.tencent.mm.sdk.platformtools.Log;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int afVy = -16777216;
  private ViewGroup afVA;
  private ImageView afVB;
  private ImageView afVC;
  private ImageView afVD;
  private final Runnable afVE;
  private boolean afVz;
  private boolean bwb;
  private int dotColor;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.dotColor = afVy;
    this.bwb = false;
    this.afVz = false;
    this.afVE = new Runnable()
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
    this.dotColor = afVy;
    this.bwb = false;
    this.afVz = false;
    this.afVE = new Runnable()
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
  
  private static AnimationDrawable g(int paramInt, float[] paramArrayOfFloat)
  {
    int i = 0;
    AppMethodBeat.i(131612);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    Log.i("ThreeDotsLoadingView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    while (i < 3)
    {
      localAnimationDrawable.addFrame(r(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.afVA = ((ViewGroup)LayoutInflater.from(paramContext).inflate(q.d.layout_three_dots_loading_view, this, true));
    afVy = paramContext.getResources().getColor(q.b.black_color);
    this.dotColor = afVy;
    this.afVB = ((ImageView)this.afVA.findViewById(q.c.loading_dot0));
    this.afVC = ((ImageView)this.afVA.findViewById(q.c.loading_dot1));
    this.afVD = ((ImageView)this.afVA.findViewById(q.c.loading_dot2));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, q.e.ThreeDotsLoadingView);
      this.dotColor = paramContext.getColor(q.e.ThreeDotsLoadingView_dotColor, afVy);
      paramContext.recycle();
    }
    jFg();
    AppMethodBeat.o(131605);
  }
  
  private void jFg()
  {
    AppMethodBeat.i(131611);
    this.afVB.setImageDrawable(r(this.dotColor, 0.5F));
    this.afVC.setImageDrawable(r(this.dotColor, 0.4F));
    this.afVD.setImageDrawable(r(this.dotColor, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private static Drawable r(int paramInt, float paramFloat)
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
  
  public final void jFe()
  {
    AppMethodBeat.i(131609);
    if (!z.ay(this))
    {
      this.afVz = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.bwb)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.bwb = true;
    jFg();
    postDelayed(this.afVE, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void jFf()
  {
    AppMethodBeat.i(131610);
    this.afVz = false;
    if (!this.bwb)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.bwb = false;
    removeCallbacks(this.afVE);
    if ((this.afVB.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.afVB.getDrawable()).stop();
      ((AnimationDrawable)this.afVC.getDrawable()).stop();
      ((AnimationDrawable)this.afVD.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.afVz)
    {
      this.afVz = false;
      jFe();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.afVB.setAlpha(paramFloat);
    this.afVC.setAlpha(paramFloat);
    this.afVD.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      jFf();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */