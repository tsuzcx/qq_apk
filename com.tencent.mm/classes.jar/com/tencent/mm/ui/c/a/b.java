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
  private static final WeakHashMap<View, b> OMi = new WeakHashMap(0);
  protected HashMap<Animator, Runnable> OMj;
  protected HashMap<Animator, Runnable> OMk;
  protected Runnable OMl;
  protected Runnable OMm;
  protected a OMn;
  
  public static b gu(View paramView)
  {
    b localb = (b)OMi.get(paramView);
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
      OMi.put(paramView, localObject);
      return localObject;
      label53:
      if (i >= 16) {
        localObject = new d(paramView);
      } else {
        localObject = new c(paramView);
      }
    }
  }
  
  @TargetApi(11)
  public b a(a parama)
  {
    this.OMn = parama;
    return this;
  }
  
  public abstract b aJ(Runnable paramRunnable);
  
  public abstract b aK(Runnable paramRunnable);
  
  public abstract b c(Interpolator paramInterpolator);
  
  public abstract b cn(float paramFloat);
  
  public abstract b co(float paramFloat);
  
  public abstract b cp(float paramFloat);
  
  public abstract b cq(float paramFloat);
  
  public abstract b gKg();
  
  public abstract void start();
  
  public static abstract interface a
  {
    public abstract void by(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */