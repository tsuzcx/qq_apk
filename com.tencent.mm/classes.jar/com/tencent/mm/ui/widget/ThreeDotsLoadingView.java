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
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.n.b;
import com.tencent.mm.plugin.appbrand.widget.n.c;
import com.tencent.mm.plugin.appbrand.widget.n.d;
import com.tencent.mm.plugin.appbrand.widget.n.e;
import com.tencent.mm.sdk.platformtools.Log;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private static int YdE = -16777216;
  private boolean PJ;
  private boolean YdF;
  private ViewGroup YdG;
  private ImageView YdH;
  private ImageView YdI;
  private ImageView YdJ;
  private final Runnable YdK;
  private int dotColor;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131603);
    this.dotColor = YdE;
    this.PJ = false;
    this.YdF = false;
    this.YdK = new Runnable()
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
    this.dotColor = YdE;
    this.PJ = false;
    this.YdF = false;
    this.YdK = new Runnable()
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
      localAnimationDrawable.addFrame(o(paramInt, paramArrayOfFloat[i]), 300);
      i += 1;
    }
    AppMethodBeat.o(131612);
    return localAnimationDrawable;
  }
  
  private void hZZ()
  {
    AppMethodBeat.i(131611);
    this.YdH.setImageDrawable(o(this.dotColor, 0.5F));
    this.YdI.setImageDrawable(o(this.dotColor, 0.4F));
    this.YdJ.setImageDrawable(o(this.dotColor, 0.3F));
    AppMethodBeat.o(131611);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(131605);
    this.YdG = ((ViewGroup)LayoutInflater.from(paramContext).inflate(n.d.layout_three_dots_loading_view, this, true));
    YdE = paramContext.getResources().getColor(n.b.black_color);
    this.dotColor = YdE;
    this.YdH = ((ImageView)this.YdG.findViewById(n.c.loading_dot0));
    this.YdI = ((ImageView)this.YdG.findViewById(n.c.loading_dot1));
    this.YdJ = ((ImageView)this.YdG.findViewById(n.c.loading_dot2));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, n.e.ThreeDotsLoadingView);
      this.dotColor = paramContext.getColor(n.e.ThreeDotsLoadingView_dotColor, YdE);
      paramContext.recycle();
    }
    hZZ();
    AppMethodBeat.o(131605);
  }
  
  private static Drawable o(int paramInt, float paramFloat)
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
  
  public final void hZX()
  {
    AppMethodBeat.i(131609);
    if (!w.al(this))
    {
      this.YdF = true;
      AppMethodBeat.o(131609);
      return;
    }
    if (this.PJ)
    {
      AppMethodBeat.o(131609);
      return;
    }
    this.PJ = true;
    hZZ();
    postDelayed(this.YdK, 300L);
    AppMethodBeat.o(131609);
  }
  
  public final void hZY()
  {
    AppMethodBeat.i(131610);
    this.YdF = false;
    if (!this.PJ)
    {
      AppMethodBeat.o(131610);
      return;
    }
    this.PJ = false;
    removeCallbacks(this.YdK);
    if ((this.YdH.getDrawable() instanceof AnimationDrawable))
    {
      ((AnimationDrawable)this.YdH.getDrawable()).stop();
      ((AnimationDrawable)this.YdI.getDrawable()).stop();
      ((AnimationDrawable)this.YdJ.getDrawable()).stop();
    }
    AppMethodBeat.o(131610);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(131607);
    super.onAttachedToWindow();
    if (this.YdF)
    {
      this.YdF = false;
      hZX();
    }
    AppMethodBeat.o(131607);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(131608);
    this.YdH.setAlpha(paramFloat);
    this.YdI.setAlpha(paramFloat);
    this.YdJ.setAlpha(paramFloat);
    if (getBackground() != null) {
      getBackground().setAlpha(Math.round(255.0F * paramFloat));
    }
    AppMethodBeat.o(131608);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(131606);
    if ((8 == paramInt) || (4 == paramInt)) {
      hZY();
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(131606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.ThreeDotsLoadingView
 * JD-Core Version:    0.7.0.1
 */