package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.k.a;
import com.tencent.mm.sdk.platformtools.Log;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int QFh = -16777216;
  private boolean FR;
  private int QFi;
  private boolean QFj;
  private ViewGroup QFk;
  private ImageView QFl;
  private ImageView QFm;
  private ImageView QFn;
  private final Runnable QFo;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.QFi = QFh;
    this.FR = false;
    this.QFj = false;
    this.QFo = new Runnable()
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
    this.QFi = QFh;
    this.FR = false;
    this.QFj = false;
    this.QFo = new Runnable()
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
      localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void gZj()
  {
    AppMethodBeat.i(131611);
    this.QFl.setImageDrawable(n(this.QFi, 0.5F));
    this.QFm.setImageDrawable(n(this.QFi, 0.4F));
    this.QFn.setImageDrawable(n(this.QFi, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.QFk = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131495197, this, true));
    QFh = paramContext.getResources().getColor(2131100044);
    this.QFi = QFh;
    this.QFl = ((ImageView)this.QFk.findViewById(2131303697));
    this.QFm = ((ImageView)this.QFk.findViewById(2131303698));
    this.QFn = ((ImageView)this.QFk.findViewById(2131303699));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.a.ThreeDotsLoadingView);
      this.QFi = paramContext.getColor(0, QFh);
      paramContext.recycle();
    }
    gZj();
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
  
  public final void gZh()
  {
    AppMethodBeat.i(131609);
    if (!u.aD(this))
    {
      this.QFj = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.FR)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.FR = true;
    gZj();
    postDelayed(this.QFo, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void gZi()
  {
    AppMethodBeat.i(131610);
    this.QFj = false;
    if (!this.FR)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.FR = false;
    removeCallbacks(this.QFo);
    if ((this.QFl.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.QFl.getDrawable()).stop();
      ((AnimationDrawable)this.QFm.getDrawable()).stop();
      ((AnimationDrawable)this.QFn.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.QFj)
    {
      this.QFj = false;
      gZh();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.QFl.setAlpha(paramFloat);
    this.QFm.setAlpha(paramFloat);
    this.QFn.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      gZi();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */