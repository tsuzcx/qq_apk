package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private boolean IK = false;
  private int dotColor = -16777216;
  private boolean wlu = false;
  private ViewGroup wlv;
  private ImageView wlw;
  private ImageView wlx;
  private ImageView wly;
  private final Runnable wlz = new Runnable()
  {
    public final void run()
    {
      ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
      ((AnimationDrawable)ThreeDotsLoadingView.b(ThreeDotsLoadingView.this).getDrawable()).start();
      ((AnimationDrawable)ThreeDotsLoadingView.c(ThreeDotsLoadingView.this).getDrawable()).start();
      ((AnimationDrawable)ThreeDotsLoadingView.d(ThreeDotsLoadingView.this).getDrawable()).start();
    }
  };
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void cKd()
  {
    this.wlw.setImageDrawable(h(this.dotColor, 0.5F));
    this.wlx.setImageDrawable(h(this.dotColor, 0.4F));
    this.wly.setImageDrawable(h(this.dotColor, 0.3F));
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    int i = 0;
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.setOneShot(false);
    while (i < 3)
    {
      localAnimationDrawable.addFrame(h(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    return localAnimationDrawable;
  }
  
  private static Drawable h(int paramInt, float paramFloat)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    return localShapeDrawable;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.wlv = ((ViewGroup)LayoutInflater.from(paramContext).inflate(a.h.layout_three_dots_loading_view, this, true));
    this.wlw = ((ImageView)this.wlv.findViewById(a.g.loading_dot0));
    this.wlx = ((ImageView)this.wlv.findViewById(a.g.loading_dot1));
    this.wly = ((ImageView)this.wlv.findViewById(a.g.loading_dot2));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.ThreeDotsLoadingView);
      this.dotColor = paramContext.getColor(a.m.ThreeDotsLoadingView_dotColor, -16777216);
      paramContext.recycle();
    }
    cKd();
  }
  
  public final void cKb()
  {
    if (!q.ao(this)) {
      this.wlu = true;
    }
    while (this.IK) {
      return;
    }
    this.IK = true;
    cKd();
    postDelayed(this.wlz, 300L);
  }
  
  public final void cKc()
  {
    this.wlu = false;
    if (!this.IK) {}
    do
    {
      return;
      this.IK = false;
      removeCallbacks(this.wlz);
    } while (!(this.wlw.getDrawable() instanceof AnimationDrawable));
    ((AnimationDrawable)this.wlw.getDrawable()).stop();
    ((AnimationDrawable)this.wlx.getDrawable()).stop();
    ((AnimationDrawable)this.wly.getDrawable()).stop();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.wlu)
    {
      this.wlu = false;
      cKb();
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    this.wlw.setAlpha(paramFloat);
    this.wlx.setAlpha(paramFloat);
    this.wly.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if ((8 == paramInt) || (4 == paramInt)) {
      cKc();
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */