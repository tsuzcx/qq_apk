package com.tencent.mm.ui.widget;

import android.content.Context;
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
import com.tencent.mm.sdk.platformtools.ab;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private int AFo;
  private boolean AFp;
  private ViewGroup AFq;
  private ImageView AFr;
  private ImageView AFs;
  private ImageView AFt;
  private final Runnable AFu;
  private boolean wu;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(77515);
    this.AFo = -16777216;
    this.wu = false;
    this.AFp = false;
    this.AFu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77514);
        ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
        ((AnimationDrawable)ThreeDotsLoadingView.b(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.c(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.d(ThreeDotsLoadingView.this).getDrawable()).start();
        AppMethodBeat.o(77514);
      }
    };
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(77515);
  }
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77516);
    this.AFo = -16777216;
    this.wu = false;
    this.AFp = false;
    this.AFu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77514);
        ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
        ((AnimationDrawable)ThreeDotsLoadingView.b(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.c(ThreeDotsLoadingView.this).getDrawable()).start();
        ((AnimationDrawable)ThreeDotsLoadingView.d(ThreeDotsLoadingView.this).getDrawable()).start();
        AppMethodBeat.o(77514);
      }
    };
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(77516);
  }
  
  private void dOX()
  {
    AppMethodBeat.i(77523);
    this.AFr.setImageDrawable(j(this.AFo, 0.5F));
    this.AFs.setImageDrawable(j(this.AFo, 0.4F));
    this.AFt.setImageDrawable(j(this.AFo, 0.3F));
    AppMethodBeat.o(77523);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    int i = 0;
    AppMethodBeat.i(77524);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    ab.i("ThreeDotsLoadingView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    while (i < 3)
    {
      localAnimationDrawable.addFrame(j(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(77524);
    return localAnimationDrawable;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(77517);
    this.AFq = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2130969975, this, true));
    this.AFr = ((ImageView)this.AFq.findViewById(2131825405));
    this.AFs = ((ImageView)this.AFq.findViewById(2131825406));
    this.AFt = ((ImageView)this.AFq.findViewById(2131825407));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, l.a.ThreeDotsLoadingView);
      this.AFo = paramContext.getColor(0, -16777216);
      paramContext.recycle();
    }
    dOX();
    AppMethodBeat.o(77517);
  }
  
  private static Drawable j(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(77525);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    AppMethodBeat.o(77525);
    return localShapeDrawable;
  }
  
  public final void dOV()
  {
    AppMethodBeat.i(77521);
    if (!t.aw(this))
    {
      this.AFp = true;
      AppMethodBeat.o(77521);
      return;
    }
    if (this.wu)
    {
      AppMethodBeat.o(77521);
      return;
    }
    this.wu = true;
    dOX();
    postDelayed(this.AFu, 300L);
    AppMethodBeat.o(77521);
  }
  
  public final void dOW()
  {
    AppMethodBeat.i(77522);
    this.AFp = false;
    if (!this.wu)
    {
      AppMethodBeat.o(77522);
      return;
    }
    this.wu = false;
    removeCallbacks(this.AFu);
    if ((this.AFr.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.AFr.getDrawable()).stop();
      ((AnimationDrawable)this.AFs.getDrawable()).stop();
      ((AnimationDrawable)this.AFt.getDrawable()).stop();
    }
    AppMethodBeat.o(77522);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(77519);
    super.onAttachedToWindow();
    if (this.AFp)
    {
      this.AFp = false;
      dOV();
    }
    AppMethodBeat.o(77519);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(77520);
    this.AFr.setAlpha(paramFloat);
    this.AFs.setAlpha(paramFloat);
    this.AFt.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(77520);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(77518);
    if ((8 == paramInt) || (4 == paramInt)) {
      dOW();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(77518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */