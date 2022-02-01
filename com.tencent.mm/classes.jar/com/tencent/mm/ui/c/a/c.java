package com.tencent.mm.ui.c.a;

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
  final WeakReference<View> NQ;
  boolean WfN;
  boolean WfO;
  boolean WfP;
  Animator.AnimatorListener WfQ;
  a WfR;
  ArrayList<b> WfS;
  Runnable WfT;
  HashMap<Animator, c> WfU;
  long arw;
  long mDuration;
  Interpolator mInterpolator;
  
  c(View paramView)
  {
    AppMethodBeat.i(199384);
    this.WfN = false;
    this.arw = 0L;
    this.WfO = false;
    this.WfP = false;
    this.WfQ = null;
    this.WfR = new a();
    this.WfS = new ArrayList();
    this.WfT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216835);
        c.this.startAnimation();
        AppMethodBeat.o(216835);
      }
    };
    this.WfU = new HashMap();
    this.NQ = new WeakReference(paramView);
    AppMethodBeat.o(199384);
  }
  
  private void A(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(199403);
    float f = aul(paramInt);
    e(paramInt, f, paramFloat - f);
    AppMethodBeat.o(199403);
  }
  
  private float aul(int paramInt)
  {
    AppMethodBeat.i(199411);
    View localView = (View)this.NQ.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(199411);
      return 0.0F;
    case 1: 
      f = localView.getTranslationX();
      AppMethodBeat.o(199411);
      return f;
    case 2: 
      f = localView.getTranslationY();
      AppMethodBeat.o(199411);
      return f;
    case 16: 
      f = localView.getRotation();
      AppMethodBeat.o(199411);
      return f;
    case 32: 
      f = localView.getRotationX();
      AppMethodBeat.o(199411);
      return f;
    case 64: 
      f = localView.getRotationY();
      AppMethodBeat.o(199411);
      return f;
    case 4: 
      f = localView.getScaleX();
      AppMethodBeat.o(199411);
      return f;
    case 8: 
      f = localView.getScaleY();
      AppMethodBeat.o(199411);
      return f;
    case 128: 
      f = localView.getX();
      AppMethodBeat.o(199411);
      return f;
    case 256: 
      f = localView.getY();
      AppMethodBeat.o(199411);
      return f;
    }
    float f = localView.getAlpha();
    AppMethodBeat.o(199411);
    return f;
  }
  
  private void e(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199404);
    Object localObject;
    if (this.WfU.size() > 0)
    {
      Iterator localIterator = this.WfU.keySet().iterator();
      c localc;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Animator)localIterator.next();
        localc = (c)this.WfU.get(localObject);
      } while ((!localc.aum(paramInt)) || (localc.WfZ != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new b(paramInt, paramFloat1, paramFloat2);
      this.WfS.add(localObject);
      localObject = (View)this.NQ.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.WfT);
        ((View)localObject).post(this.WfT);
      }
      AppMethodBeat.o(199404);
      return;
      localObject = null;
    }
  }
  
  public final b Vw(long paramLong)
  {
    AppMethodBeat.i(199386);
    if (paramLong < 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Animators cannot have negative duration: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(199386);
      throw localIllegalArgumentException;
    }
    this.WfN = true;
    this.mDuration = paramLong;
    AppMethodBeat.o(199386);
    return this;
  }
  
  public final b aP(Runnable paramRunnable)
  {
    AppMethodBeat.i(199413);
    this.WfL = paramRunnable;
    if (this.WfJ == null) {
      this.WfJ = new HashMap();
    }
    AppMethodBeat.o(199413);
    return this;
  }
  
  public final b aQ(Runnable paramRunnable)
  {
    AppMethodBeat.i(199415);
    this.WfK = paramRunnable;
    if (this.WfI == null) {
      this.WfI = new HashMap();
    }
    AppMethodBeat.o(199415);
    return this;
  }
  
  public final b c(Interpolator paramInterpolator)
  {
    this.WfP = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }
  
  public final b cE(float paramFloat)
  {
    AppMethodBeat.i(199393);
    A(16, paramFloat);
    AppMethodBeat.o(199393);
    return this;
  }
  
  public final b cF(float paramFloat)
  {
    AppMethodBeat.i(199394);
    A(1, paramFloat);
    AppMethodBeat.o(199394);
    return this;
  }
  
  public final b cG(float paramFloat)
  {
    AppMethodBeat.i(199396);
    A(2, paramFloat);
    AppMethodBeat.o(199396);
    return this;
  }
  
  public final b cH(float paramFloat)
  {
    AppMethodBeat.i(199397);
    A(4, paramFloat);
    AppMethodBeat.o(199397);
    return this;
  }
  
  public final b cI(float paramFloat)
  {
    AppMethodBeat.i(199399);
    A(8, paramFloat);
    AppMethodBeat.o(199399);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(199390);
    View localView = (View)this.NQ.get();
    if (localView != null) {
      localView.removeCallbacks(this.WfT);
    }
    startAnimation();
    AppMethodBeat.o(199390);
  }
  
  final void startAnimation()
  {
    AppMethodBeat.i(199402);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.WfS.clone();
    this.WfS.clear();
    int k = localArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j |= ((b)localArrayList.get(i)).WfW;
      i += 1;
    }
    if (this.WfK != null)
    {
      this.WfI.put(localValueAnimator, this.WfK);
      this.WfK = null;
    }
    if (this.WfL != null)
    {
      this.WfJ.put(localValueAnimator, this.WfL);
      this.WfL = null;
    }
    this.WfU.put(localValueAnimator, new c(j, localArrayList));
    localValueAnimator.addUpdateListener(this.WfR);
    localValueAnimator.addListener(this.WfR);
    if (this.WfO) {
      localValueAnimator.setStartDelay(this.arw);
    }
    if (this.WfN) {
      localValueAnimator.setDuration(this.mDuration);
    }
    if (this.WfP) {
      localValueAnimator.setInterpolator(this.mInterpolator);
    }
    localValueAnimator.start();
    AppMethodBeat.o(199402);
  }
  
  final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(221128);
      if (c.this.WfQ != null) {
        c.this.WfQ.onAnimationCancel(paramAnimator);
      }
      if (c.this.WfJ != null) {
        c.this.WfJ.remove(paramAnimator);
      }
      AppMethodBeat.o(221128);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221134);
      if (c.this.WfQ != null) {
        c.this.WfQ.onAnimationEnd(paramAnimator);
      }
      if (c.this.WfJ != null)
      {
        Runnable localRunnable = (Runnable)c.this.WfJ.get(paramAnimator);
        if (localRunnable != null) {
          localRunnable.run();
        }
        c.this.WfJ.remove(paramAnimator);
      }
      c.this.WfU.remove(paramAnimator);
      if (c.this.WfU.isEmpty()) {
        c.this.WfQ = null;
      }
      AppMethodBeat.o(221134);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(221130);
      if (c.this.WfQ != null) {
        c.this.WfQ.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(221130);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(221124);
      if (c.this.WfQ != null) {
        c.this.WfQ.onAnimationStart(paramAnimator);
      }
      if (c.this.WfI != null)
      {
        Runnable localRunnable = (Runnable)c.this.WfI.get(paramAnimator);
        if (localRunnable != null) {
          localRunnable.run();
        }
        c.this.WfI.remove(paramAnimator);
      }
      AppMethodBeat.o(221124);
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(221148);
      float f1 = paramValueAnimator.getAnimatedFraction();
      if (c.this.WfM != null) {
        c.this.WfM.bB(f1);
      }
      paramValueAnimator = (c.c)c.this.WfU.get(paramValueAnimator);
      Object localObject;
      if ((paramValueAnimator.WfZ & 0x1FF) != 0)
      {
        localObject = (View)c.this.NQ.get();
        if (localObject != null) {
          ((View)localObject).invalidate();
        }
      }
      paramValueAnimator = paramValueAnimator.Wga;
      if (paramValueAnimator != null)
      {
        int j = paramValueAnimator.size();
        int i = 0;
        if (i < j)
        {
          localObject = (c.b)paramValueAnimator.get(i);
          float f2 = ((c.b)localObject).WfX + ((c.b)localObject).WfY * f1;
          c localc = c.this;
          int k = ((c.b)localObject).WfW;
          localObject = (View)localc.NQ.get();
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
      paramValueAnimator = (View)c.this.NQ.get();
      if (paramValueAnimator != null) {
        paramValueAnimator.invalidate();
      }
      AppMethodBeat.o(221148);
    }
  }
  
  static final class b
  {
    int WfW;
    float WfX;
    float WfY;
    
    b(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.WfW = paramInt;
      this.WfX = paramFloat1;
      this.WfY = paramFloat2;
    }
  }
  
  static final class c
  {
    int WfZ;
    ArrayList<c.b> Wga;
    
    c(int paramInt, ArrayList<c.b> paramArrayList)
    {
      this.WfZ = paramInt;
      this.Wga = paramArrayList;
    }
    
    final boolean aum(int paramInt)
    {
      AppMethodBeat.i(188823);
      if (((this.WfZ & paramInt) != 0) && (this.Wga != null))
      {
        int j = this.Wga.size();
        int i = 0;
        while (i < j)
        {
          if (((c.b)this.Wga.get(i)).WfW == paramInt)
          {
            this.Wga.remove(i);
            this.WfZ &= (paramInt ^ 0xFFFFFFFF);
            AppMethodBeat.o(188823);
            return true;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(188823);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */