package com.tencent.mm.ui.anim.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class c
  extends b
{
  boolean adLU;
  boolean adLV;
  boolean adLW;
  Animator.AnimatorListener adLX;
  a adLY;
  ArrayList<b> adLZ;
  Runnable adMa;
  HashMap<Animator, c> adMb;
  final WeakReference<View> btW;
  long cge;
  long mDuration;
  Interpolator mInterpolator;
  
  c(View paramView)
  {
    AppMethodBeat.i(251244);
    this.adLU = false;
    this.cge = 0L;
    this.adLV = false;
    this.adLW = false;
    this.adLX = null;
    this.adLY = new a();
    this.adLZ = new ArrayList();
    this.adMa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(251257);
        c.this.startAnimation();
        AppMethodBeat.o(251257);
      }
    };
    this.adMb = new HashMap();
    this.btW = new WeakReference(paramView);
    AppMethodBeat.o(251244);
  }
  
  private void D(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(251252);
    float f = aAH(paramInt);
    f(paramInt, f, paramFloat - f);
    AppMethodBeat.o(251252);
  }
  
  private float aAH(int paramInt)
  {
    AppMethodBeat.i(251271);
    View localView = (View)this.btW.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(251271);
      return 0.0F;
    case 1: 
      f = localView.getTranslationX();
      AppMethodBeat.o(251271);
      return f;
    case 2: 
      f = localView.getTranslationY();
      AppMethodBeat.o(251271);
      return f;
    case 16: 
      f = localView.getRotation();
      AppMethodBeat.o(251271);
      return f;
    case 32: 
      f = localView.getRotationX();
      AppMethodBeat.o(251271);
      return f;
    case 64: 
      f = localView.getRotationY();
      AppMethodBeat.o(251271);
      return f;
    case 4: 
      f = localView.getScaleX();
      AppMethodBeat.o(251271);
      return f;
    case 8: 
      f = localView.getScaleY();
      AppMethodBeat.o(251271);
      return f;
    case 128: 
      f = localView.getX();
      AppMethodBeat.o(251271);
      return f;
    case 256: 
      f = localView.getY();
      AppMethodBeat.o(251271);
      return f;
    }
    float f = localView.getAlpha();
    AppMethodBeat.o(251271);
    return f;
  }
  
  private void f(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251263);
    Object localObject;
    if (this.adMb.size() > 0)
    {
      Iterator localIterator = this.adMb.keySet().iterator();
      c localc;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Animator)localIterator.next();
        localc = (c)this.adMb.get(localObject);
      } while ((!localc.aAI(paramInt)) || (localc.adMg != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new b(paramInt, paramFloat1, paramFloat2);
      this.adLZ.add(localObject);
      localObject = (View)this.btW.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.adMa);
        ((View)localObject).post(this.adMa);
      }
      AppMethodBeat.o(251263);
      return;
      localObject = null;
    }
  }
  
  public final b aX(Runnable paramRunnable)
  {
    AppMethodBeat.i(251304);
    this.adLS = paramRunnable;
    if ((paramRunnable != null) && (this.adLQ == null)) {
      this.adLQ = new HashMap();
    }
    AppMethodBeat.o(251304);
    return this;
  }
  
  public final b aY(Runnable paramRunnable)
  {
    AppMethodBeat.i(251306);
    this.adLR = paramRunnable;
    if ((paramRunnable != null) && (this.adLP == null)) {
      this.adLP = new HashMap();
    }
    AppMethodBeat.o(251306);
    return this;
  }
  
  public final b d(Interpolator paramInterpolator)
  {
    this.adLW = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }
  
  public final b dR(float paramFloat)
  {
    AppMethodBeat.i(251286);
    D(16, paramFloat);
    AppMethodBeat.o(251286);
    return this;
  }
  
  public final b dS(float paramFloat)
  {
    AppMethodBeat.i(251290);
    D(1, paramFloat);
    AppMethodBeat.o(251290);
    return this;
  }
  
  public final b dT(float paramFloat)
  {
    AppMethodBeat.i(251292);
    D(2, paramFloat);
    AppMethodBeat.o(251292);
    return this;
  }
  
  public final b dU(float paramFloat)
  {
    AppMethodBeat.i(251295);
    D(4, paramFloat);
    AppMethodBeat.o(251295);
    return this;
  }
  
  public final b dV(float paramFloat)
  {
    AppMethodBeat.i(251298);
    D(8, paramFloat);
    AppMethodBeat.o(251298);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(251283);
    View localView = (View)this.btW.get();
    if (localView != null) {
      localView.removeCallbacks(this.adMa);
    }
    startAnimation();
    AppMethodBeat.o(251283);
  }
  
  final void startAnimation()
  {
    AppMethodBeat.i(251302);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.adLZ.clone();
    this.adLZ.clear();
    int k = localArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j |= ((b)localArrayList.get(i)).adMd;
      i += 1;
    }
    if (this.adLR != null)
    {
      this.adLP.put(localValueAnimator, this.adLR);
      this.adLR = null;
    }
    if (this.adLS != null)
    {
      this.adLQ.put(localValueAnimator, this.adLS);
      this.adLS = null;
    }
    this.adMb.put(localValueAnimator, new c(j, localArrayList));
    localValueAnimator.addUpdateListener(this.adLY);
    localValueAnimator.addListener(this.adLY);
    if (this.adLV) {
      localValueAnimator.setStartDelay(this.cge);
    }
    if (this.adLU) {
      localValueAnimator.setDuration(this.mDuration);
    }
    if (this.adLW) {
      localValueAnimator.setInterpolator(this.mInterpolator);
    }
    localValueAnimator.start();
    AppMethodBeat.o(251302);
  }
  
  public final b zE(long paramLong)
  {
    AppMethodBeat.i(251275);
    if (paramLong < 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(251275);
      throw localIllegalArgumentException;
    }
    this.adLU = true;
    this.mDuration = paramLong;
    AppMethodBeat.o(251275);
    return this;
  }
  
  final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(251266);
      if (c.this.adLX != null) {
        c.this.adLX.onAnimationCancel(paramAnimator);
      }
      if (c.this.adLQ != null) {
        c.this.adLQ.remove(paramAnimator);
      }
      AppMethodBeat.o(251266);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(251276);
      if (c.this.adLX != null) {
        c.this.adLX.onAnimationEnd(paramAnimator);
      }
      if (c.this.adLQ != null)
      {
        Runnable localRunnable = (Runnable)c.this.adLQ.get(paramAnimator);
        if (localRunnable != null) {
          localRunnable.run();
        }
        c.this.adLQ.remove(paramAnimator);
      }
      c.this.adMb.remove(paramAnimator);
      if (c.this.adMb.isEmpty()) {
        c.this.adLX = null;
      }
      AppMethodBeat.o(251276);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(251269);
      if (c.this.adLX != null) {
        c.this.adLX.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(251269);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(251256);
      if (c.this.adLX != null) {
        c.this.adLX.onAnimationStart(paramAnimator);
      }
      if (c.this.adLP != null)
      {
        Runnable localRunnable = (Runnable)c.this.adLP.get(paramAnimator);
        if (localRunnable != null) {
          localRunnable.run();
        }
        c.this.adLP.remove(paramAnimator);
      }
      AppMethodBeat.o(251256);
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(251282);
      float f1 = paramValueAnimator.getAnimatedFraction();
      if (c.this.adLT != null) {
        c.this.adLT.onUpdate(f1);
      }
      paramValueAnimator = (c.c)c.this.adMb.get(paramValueAnimator);
      Object localObject;
      if ((paramValueAnimator.adMg & 0x1FF) != 0)
      {
        localObject = (View)c.this.btW.get();
        if (localObject != null) {
          ((View)localObject).invalidate();
        }
      }
      paramValueAnimator = paramValueAnimator.adMh;
      if (paramValueAnimator != null)
      {
        int j = paramValueAnimator.size();
        int i = 0;
        if (i < j)
        {
          localObject = (c.b)paramValueAnimator.get(i);
          float f2 = ((c.b)localObject).adMe + ((c.b)localObject).adMf * f1;
          c localc = c.this;
          int k = ((c.b)localObject).adMd;
          localObject = (View)localc.btW.get();
          if (localObject != null) {
            switch (k)
            {
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((View)localObject).setTranslationX(f2);
            continue;
            ((View)localObject).setTranslationY(f2);
            continue;
            ((View)localObject).setRotation(f2);
            continue;
            ((View)localObject).setRotationX(f2);
            continue;
            ((View)localObject).setRotationY(f2);
            continue;
            ((View)localObject).setScaleX(f2);
            continue;
            ((View)localObject).setScaleY(f2);
            continue;
            ((View)localObject).setX(f2);
            continue;
            ((View)localObject).setY(f2);
            continue;
            ((View)localObject).setAlpha(f2);
          }
        }
      }
      paramValueAnimator = (View)c.this.btW.get();
      if (paramValueAnimator != null) {
        paramValueAnimator.invalidate();
      }
      AppMethodBeat.o(251282);
    }
  }
  
  static final class b
  {
    int adMd;
    float adMe;
    float adMf;
    
    b(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.adMd = paramInt;
      this.adMe = paramFloat1;
      this.adMf = paramFloat2;
    }
  }
  
  static final class c
  {
    int adMg;
    ArrayList<c.b> adMh;
    
    c(int paramInt, ArrayList<c.b> paramArrayList)
    {
      this.adMg = paramInt;
      this.adMh = paramArrayList;
    }
    
    final boolean aAI(int paramInt)
    {
      AppMethodBeat.i(251259);
      if (((this.adMg & paramInt) != 0) && (this.adMh != null))
      {
        int j = this.adMh.size();
        int i = 0;
        while (i < j)
        {
          if (((c.b)this.adMh.get(i)).adMd == paramInt)
          {
            this.adMh.remove(i);
            this.adMg &= (paramInt ^ 0xFFFFFFFF);
            AppMethodBeat.o(251259);
            return true;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(251259);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.anim.a.c
 * JD-Core Version:    0.7.0.1
 */