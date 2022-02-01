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
  long Cd;
  boolean OMo;
  boolean OMp;
  boolean OMq;
  Animator.AnimatorListener OMr;
  a OMs;
  ArrayList<b> OMt;
  Runnable OMu;
  HashMap<Animator, c> OMv;
  final WeakReference<View> Rd;
  long mDuration;
  Interpolator mInterpolator;
  
  c(View paramView)
  {
    AppMethodBeat.i(205166);
    this.OMo = false;
    this.Cd = 0L;
    this.OMp = false;
    this.OMq = false;
    this.OMr = null;
    this.OMs = new a();
    this.OMt = new ArrayList();
    this.OMu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205159);
        c.this.startAnimation();
        AppMethodBeat.o(205159);
      }
    };
    this.OMv = new HashMap();
    this.Rd = new WeakReference(paramView);
    AppMethodBeat.o(205166);
  }
  
  private void A(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(205174);
    float f = alo(paramInt);
    e(paramInt, f, paramFloat - f);
    AppMethodBeat.o(205174);
  }
  
  private float alo(int paramInt)
  {
    AppMethodBeat.i(205176);
    View localView = (View)this.Rd.get();
    if (localView != null) {}
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(205176);
      return 0.0F;
    case 1: 
      f = localView.getTranslationX();
      AppMethodBeat.o(205176);
      return f;
    case 2: 
      f = localView.getTranslationY();
      AppMethodBeat.o(205176);
      return f;
    case 16: 
      f = localView.getRotation();
      AppMethodBeat.o(205176);
      return f;
    case 32: 
      f = localView.getRotationX();
      AppMethodBeat.o(205176);
      return f;
    case 64: 
      f = localView.getRotationY();
      AppMethodBeat.o(205176);
      return f;
    case 4: 
      f = localView.getScaleX();
      AppMethodBeat.o(205176);
      return f;
    case 8: 
      f = localView.getScaleY();
      AppMethodBeat.o(205176);
      return f;
    case 128: 
      f = localView.getX();
      AppMethodBeat.o(205176);
      return f;
    case 256: 
      f = localView.getY();
      AppMethodBeat.o(205176);
      return f;
    }
    float f = localView.getAlpha();
    AppMethodBeat.o(205176);
    return f;
  }
  
  private void e(int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205175);
    Object localObject;
    if (this.OMv.size() > 0)
    {
      Iterator localIterator = this.OMv.keySet().iterator();
      c localc;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Animator)localIterator.next();
        localc = (c)this.OMv.get(localObject);
      } while ((!localc.alp(paramInt)) || (localc.OMA != 0));
    }
    for (;;)
    {
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new b(paramInt, paramFloat1, paramFloat2);
      this.OMt.add(localObject);
      localObject = (View)this.Rd.get();
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(this.OMu);
        ((View)localObject).post(this.OMu);
      }
      AppMethodBeat.o(205175);
      return;
      localObject = null;
    }
  }
  
  public final b aJ(Runnable paramRunnable)
  {
    AppMethodBeat.i(205177);
    this.OMm = paramRunnable;
    if (this.OMk == null) {
      this.OMk = new HashMap();
    }
    AppMethodBeat.o(205177);
    return this;
  }
  
  public final b aK(Runnable paramRunnable)
  {
    AppMethodBeat.i(205178);
    this.OMl = paramRunnable;
    if (this.OMj == null) {
      this.OMj = new HashMap();
    }
    AppMethodBeat.o(205178);
    return this;
  }
  
  public final b c(Interpolator paramInterpolator)
  {
    this.OMq = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }
  
  public final b cn(float paramFloat)
  {
    AppMethodBeat.i(205169);
    A(1, paramFloat);
    AppMethodBeat.o(205169);
    return this;
  }
  
  public final b co(float paramFloat)
  {
    AppMethodBeat.i(205170);
    A(2, paramFloat);
    AppMethodBeat.o(205170);
    return this;
  }
  
  public final b cp(float paramFloat)
  {
    AppMethodBeat.i(205171);
    A(4, paramFloat);
    AppMethodBeat.o(205171);
    return this;
  }
  
  public final b cq(float paramFloat)
  {
    AppMethodBeat.i(205172);
    A(8, paramFloat);
    AppMethodBeat.o(205172);
    return this;
  }
  
  public final b gKg()
  {
    AppMethodBeat.i(205167);
    if (250L < 0L)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Animators cannot have negative duration: 250");
      AppMethodBeat.o(205167);
      throw localIllegalArgumentException;
    }
    this.OMo = true;
    this.mDuration = 250L;
    AppMethodBeat.o(205167);
    return this;
  }
  
  public final void start()
  {
    AppMethodBeat.i(205168);
    View localView = (View)this.Rd.get();
    if (localView != null) {
      localView.removeCallbacks(this.OMu);
    }
    startAnimation();
    AppMethodBeat.o(205168);
  }
  
  final void startAnimation()
  {
    AppMethodBeat.i(205173);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.OMt.clone();
    this.OMt.clear();
    int k = localArrayList.size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j |= ((b)localArrayList.get(i)).OMx;
      i += 1;
    }
    if (this.OMl != null)
    {
      this.OMj.put(localValueAnimator, this.OMl);
      this.OMl = null;
    }
    if (this.OMm != null)
    {
      this.OMk.put(localValueAnimator, this.OMm);
      this.OMm = null;
    }
    this.OMv.put(localValueAnimator, new c(j, localArrayList));
    localValueAnimator.addUpdateListener(this.OMs);
    localValueAnimator.addListener(this.OMs);
    if (this.OMp) {
      localValueAnimator.setStartDelay(this.Cd);
    }
    if (this.OMo) {
      localValueAnimator.setDuration(this.mDuration);
    }
    if (this.OMq) {
      localValueAnimator.setInterpolator(this.mInterpolator);
    }
    localValueAnimator.start();
    AppMethodBeat.o(205173);
  }
  
  final class a
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(205161);
      if (c.this.OMr != null) {
        c.this.OMr.onAnimationCancel(paramAnimator);
      }
      if (c.this.OMk != null) {
        c.this.OMk.remove(paramAnimator);
      }
      AppMethodBeat.o(205161);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205163);
      if (c.this.OMr != null) {
        c.this.OMr.onAnimationEnd(paramAnimator);
      }
      if (c.this.OMk != null)
      {
        Runnable localRunnable = (Runnable)c.this.OMk.get(paramAnimator);
        if (localRunnable != null) {
          localRunnable.run();
        }
        c.this.OMk.remove(paramAnimator);
      }
      c.this.OMv.remove(paramAnimator);
      if (c.this.OMv.isEmpty()) {
        c.this.OMr = null;
      }
      AppMethodBeat.o(205163);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(205162);
      if (c.this.OMr != null) {
        c.this.OMr.onAnimationRepeat(paramAnimator);
      }
      AppMethodBeat.o(205162);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205160);
      if (c.this.OMr != null) {
        c.this.OMr.onAnimationStart(paramAnimator);
      }
      if (c.this.OMj != null)
      {
        Runnable localRunnable = (Runnable)c.this.OMj.get(paramAnimator);
        if (localRunnable != null) {
          localRunnable.run();
        }
        c.this.OMj.remove(paramAnimator);
      }
      AppMethodBeat.o(205160);
    }
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(205164);
      float f1 = paramValueAnimator.getAnimatedFraction();
      if (c.this.OMn != null) {
        c.this.OMn.by(f1);
      }
      paramValueAnimator = (c.c)c.this.OMv.get(paramValueAnimator);
      Object localObject;
      if ((paramValueAnimator.OMA & 0x1FF) != 0)
      {
        localObject = (View)c.this.Rd.get();
        if (localObject != null) {
          ((View)localObject).invalidate();
        }
      }
      paramValueAnimator = paramValueAnimator.OMB;
      if (paramValueAnimator != null)
      {
        int j = paramValueAnimator.size();
        int i = 0;
        if (i < j)
        {
          localObject = (c.b)paramValueAnimator.get(i);
          float f2 = ((c.b)localObject).OMy + ((c.b)localObject).OMz * f1;
          c localc = c.this;
          int k = ((c.b)localObject).OMx;
          localObject = (View)localc.Rd.get();
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
      paramValueAnimator = (View)c.this.Rd.get();
      if (paramValueAnimator != null) {
        paramValueAnimator.invalidate();
      }
      AppMethodBeat.o(205164);
    }
  }
  
  static final class b
  {
    int OMx;
    float OMy;
    float OMz;
    
    b(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.OMx = paramInt;
      this.OMy = paramFloat1;
      this.OMz = paramFloat2;
    }
  }
  
  static final class c
  {
    int OMA;
    ArrayList<c.b> OMB;
    
    c(int paramInt, ArrayList<c.b> paramArrayList)
    {
      this.OMA = paramInt;
      this.OMB = paramArrayList;
    }
    
    final boolean alp(int paramInt)
    {
      AppMethodBeat.i(205165);
      if (((this.OMA & paramInt) != 0) && (this.OMB != null))
      {
        int j = this.OMB.size();
        int i = 0;
        while (i < j)
        {
          if (((c.b)this.OMB.get(i)).OMx == paramInt)
          {
            this.OMB.remove(i);
            this.OMA &= (paramInt ^ 0xFFFFFFFF);
            AppMethodBeat.o(205165);
            return true;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(205165);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */