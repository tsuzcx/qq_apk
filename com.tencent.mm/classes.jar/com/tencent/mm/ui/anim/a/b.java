package com.tencent.mm.ui.anim.a;

import android.animation.Animator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.HashMap;
import java.util.WeakHashMap;

public abstract class b
{
  private static final WeakHashMap<View, b> adLO = new WeakHashMap(0);
  protected HashMap<Animator, Runnable> adLP;
  protected HashMap<Animator, Runnable> adLQ;
  protected Runnable adLR;
  protected Runnable adLS;
  protected a adLT;
  
  public static b kY(View paramView)
  {
    b localb = (b)adLO.get(paramView);
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
      adLO.put(paramView, localObject);
      return localObject;
      label53:
      if (i >= 16) {
        localObject = new d(paramView);
      } else {
        localObject = new c(paramView);
      }
    }
  }
  
  public b a(a parama)
  {
    this.adLT = parama;
    return this;
  }
  
  public abstract b aX(Runnable paramRunnable);
  
  public abstract b aY(Runnable paramRunnable);
  
  public abstract b d(Interpolator paramInterpolator);
  
  public abstract b dR(float paramFloat);
  
  public abstract b dS(float paramFloat);
  
  public abstract b dT(float paramFloat);
  
  public abstract b dU(float paramFloat);
  
  public abstract b dV(float paramFloat);
  
  public abstract void start();
  
  public abstract b zE(long paramLong);
  
  public static abstract interface a
  {
    public abstract void onUpdate(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.anim.a.b
 * JD-Core Version:    0.7.0.1
 */