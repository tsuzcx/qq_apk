package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.HashMap;
import java.util.WeakHashMap;

public abstract class b
{
  private static final WeakHashMap<View, b> WfH = new WeakHashMap(0);
  protected HashMap<Animator, Runnable> WfI;
  protected HashMap<Animator, Runnable> WfJ;
  protected Runnable WfK;
  protected Runnable WfL;
  protected a WfM;
  
  public static b hF(View paramView)
  {
    b localb = (b)WfH.get(paramView);
    Object localObject = localb;
    int i;
    if (localb == null)
    {
      i = Integer.valueOf(Build.VERSION.SDK).intValue();
      if (i < 19) {
        break label53;
      }
      localObject = new e(paramView);
    }
    for (;;)
    {
      WfH.put(paramView, localObject);
      return localObject;
      label53:
      if (i >= 16) {
        localObject = new d(paramView);
      } else {
        localObject = new c(paramView);
      }
    }
  }
  
  public abstract b Vw(long paramLong);
  
  @TargetApi(11)
  public b a(a parama)
  {
    this.WfM = parama;
    return this;
  }
  
  public abstract b aP(Runnable paramRunnable);
  
  public abstract b aQ(Runnable paramRunnable);
  
  public abstract b c(Interpolator paramInterpolator);
  
  public abstract b cE(float paramFloat);
  
  public abstract b cF(float paramFloat);
  
  public abstract b cG(float paramFloat);
  
  public abstract b cH(float paramFloat);
  
  public abstract b cI(float paramFloat);
  
  public abstract void start();
  
  public static abstract interface a
  {
    public abstract void bB(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */