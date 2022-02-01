package com.tencent.tencentmap.mapsdk.vector.compat.utils.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import java.util.ArrayList;
import java.util.List;

public class MarkerTranslateAnimator
  extends OverlayAnimator
{
  private LatLng[] a;
  private double[] b;
  private double c;
  private boolean d;
  private AnimatorSet e;
  private c f;
  private volatile boolean g;
  
  public MarkerTranslateAnimator(Marker paramMarker, long paramLong, LatLng[] paramArrayOfLatLng)
  {
    this(paramMarker, paramLong, paramArrayOfLatLng, false);
  }
  
  public MarkerTranslateAnimator(Marker paramMarker, long paramLong, LatLng[] paramArrayOfLatLng, boolean paramBoolean)
  {
    super(paramMarker, paramLong);
    AppMethodBeat.i(217629);
    this.g = false;
    if (paramArrayOfLatLng == null)
    {
      AppMethodBeat.o(217629);
      return;
    }
    this.a = paramArrayOfLatLng;
    this.b = new double[paramArrayOfLatLng.length - 1];
    this.f = new c();
    int i = 0;
    while (i < paramArrayOfLatLng.length - 1)
    {
      this.b[i] = this.f.a(paramArrayOfLatLng[i], paramArrayOfLatLng[(i + 1)]);
      this.c += this.b[i];
      i += 1;
    }
    paramMarker = new ArrayList();
    i = j;
    while (i < paramArrayOfLatLng.length - 1)
    {
      paramMarker.add(createSegmentAnimator(i));
      i += 1;
    }
    getAnimatorSet().playSequentially(paramMarker);
    this.d = paramBoolean;
    if (paramBoolean) {
      a();
    }
    AppMethodBeat.o(217629);
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(217650);
    double d2 = (paramDouble1 * paramDouble3 + paramDouble2 * paramDouble4) / (Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2) * Math.sqrt(paramDouble3 * paramDouble3 + paramDouble4 * paramDouble4));
    if (Double.isNaN(d2))
    {
      AppMethodBeat.o(217650);
      return 0.0D;
    }
    double d1 = d2;
    if (d2 < -1.0D) {
      d1 = -1.0D;
    }
    d2 = d1;
    if (d1 > 1.0D) {
      d2 = 1.0D;
    }
    d2 = Math.acos(d2) * 180.0D / 3.141592653589793D;
    d1 = d2;
    if (paramDouble1 * paramDouble4 - paramDouble2 * paramDouble3 > 0.0D) {
      d1 = -d2;
    }
    paramDouble1 = (float)d1;
    AppMethodBeat.o(217650);
    return paramDouble1;
  }
  
  private long a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217657);
    double d1 = 0.0D;
    while (paramInt1 < paramInt2)
    {
      d1 += this.b[paramInt1];
      paramInt1 += 1;
    }
    long l = (d1 * getDuration() / this.c);
    AppMethodBeat.o(217657);
    return l;
  }
  
  private ValueAnimator a(float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(217666);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(paramLong1);
    localValueAnimator.setStartDelay(paramLong2);
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(217631);
        double d = Double.parseDouble(String.valueOf(paramAnonymousValueAnimator.getAnimatedValue()));
        if (MarkerTranslateAnimator.this.getObject() == null)
        {
          AppMethodBeat.o(217631);
          return;
        }
        ((Marker)MarkerTranslateAnimator.this.getObject()).setRotation((float)d);
        AppMethodBeat.o(217631);
      }
    });
    AppMethodBeat.o(217666);
    return localValueAnimator;
  }
  
  private void a()
  {
    AppMethodBeat.i(217638);
    this.e = new AnimatorSet();
    this.e.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217651);
        MarkerTranslateAnimator.a(MarkerTranslateAnimator.this, false);
        AppMethodBeat.o(217651);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(217644);
        MarkerTranslateAnimator.a(MarkerTranslateAnimator.this, false);
        AppMethodBeat.o(217644);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    float f1 = 0.0F;
    int k = 0;
    int i = 0;
    long l1 = 0L;
    float f2;
    long l2;
    if (j < this.a.length)
    {
      if (this.a[i].equals(this.a[j])) {
        break label354;
      }
      b localb1 = this.f.a(this.a[k]);
      b localb2 = this.f.a(this.a[i]);
      b localb3 = this.f.a(this.a[j]);
      f2 = (float)a(localb2.a - localb1.a, localb1.b - localb2.b, localb3.a - localb2.a, localb2.b - localb3.b);
      if (localArrayList.size() == 0)
      {
        if (getObject() == null)
        {
          AppMethodBeat.o(217638);
          return;
        }
        f1 = ((Marker)getObject()).getRotation();
        f2 = (float)a(0.0D, 1.0D, localb3.a - localb2.a, localb2.b - localb3.b) - f1;
        l2 = 0L;
        label250:
        f2 = f1 + f2;
        localArrayList.add(a(f1, f2, l2, l1));
        f1 = f2;
        k = i;
        i = j;
      }
    }
    label354:
    for (;;)
    {
      j += 1;
      break;
      l2 = (Math.abs(f2) * 3.141592653589793D * 6.0D / 180.0D * getDuration() / this.c);
      l1 = a(k, i) - l2 / 2L;
      break label250;
      this.e.playSequentially(localArrayList);
      AppMethodBeat.o(217638);
      return;
    }
  }
  
  public void cancelAnimation()
  {
    AppMethodBeat.i(217701);
    super.cancelAnimation();
    try
    {
      if ((this.d) && (this.e != null)) {
        this.e.cancel();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(217701);
    }
  }
  
  protected ValueAnimator createSegmentAnimator(final int paramInt)
  {
    AppMethodBeat.i(217689);
    final b localb1 = this.f.a(this.a[paramInt]);
    final b localb2 = this.f.a(this.a[(paramInt + 1)]);
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setDuration((getDuration() * this.b[paramInt] / this.c));
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.setFloatValues(new float[] { (float)this.b[paramInt] });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(217642);
        if (localb1.equals(localb2))
        {
          AppMethodBeat.o(217642);
          return;
        }
        double d4 = Double.parseDouble(String.valueOf(paramAnonymousValueAnimator.getAnimatedValue()));
        double d1 = localb1.a;
        double d2 = (localb2.a - localb1.a) * d4 / MarkerTranslateAnimator.a(MarkerTranslateAnimator.this)[paramInt];
        double d3 = localb1.b;
        d4 = d4 * (localb2.b - localb1.b) / MarkerTranslateAnimator.a(MarkerTranslateAnimator.this)[paramInt];
        if (MarkerTranslateAnimator.this.getObject() == null)
        {
          AppMethodBeat.o(217642);
          return;
        }
        ((Marker)MarkerTranslateAnimator.this.getObject()).setPosition(MarkerTranslateAnimator.b(MarkerTranslateAnimator.this).a(new b(d1 + d2, d3 + d4)));
        AppMethodBeat.o(217642);
      }
    });
    AppMethodBeat.o(217689);
    return localValueAnimator;
  }
  
  public void endAnimation()
  {
    AppMethodBeat.i(217707);
    super.endAnimation();
    try
    {
      if ((this.d) && (this.e != null)) {
        this.e.end();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(217707);
    }
  }
  
  public void startAnimation()
  {
    AppMethodBeat.i(217695);
    super.startAnimation();
    try
    {
      if ((this.d) && (this.e != null) && (!this.g))
      {
        this.g = true;
        this.e.start();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(217695);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator
 * JD-Core Version:    0.7.0.1
 */