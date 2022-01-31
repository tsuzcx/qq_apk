package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class sn
{
  protected tn a;
  protected tj b;
  protected uv c;
  private sn.a d = sn.a.c;
  private Handler e = new Handler();
  private Scroller f;
  private long g;
  private float h = 0.0F;
  private boolean i = false;
  private double j = 0.0D;
  private Runnable k = new Runnable()
  {
    public final void run()
    {
      if (sn.a(sn.this).computeScrollOffset())
      {
        float f1 = sn.a(sn.this).getCurrX() * 1.0F / 10000.0F;
        float f2 = f1 - sn.b(sn.this);
        sn.a(sn.this, sn.c(sn.this) + f2);
        if (sn.c(sn.this) < 1.0D) {
          sn.this.a(f2);
        }
        sn.a(sn.this, f1);
        if (sn.d(sn.this)) {
          sn.f(sn.this).postDelayed(sn.e(sn.this), 5L);
        }
        sn.this.a.h().a(false);
        return;
      }
      sn.this.d();
      if (sn.this.c != null) {
        sn.this.c.a();
      }
      sn.a(sn.this, false);
      sn.this.a.h().a(true);
    }
  };
  
  public sn(tn paramtn, long paramLong, uv paramuv)
  {
    this.a = paramtn;
    this.b = paramtn.c();
    this.g = paramLong;
    this.c = paramuv;
  }
  
  public final void a()
  {
    switch (sn.2.a[this.d.ordinal()])
    {
    default: 
      this.f = new Scroller(tn.a());
    }
    for (;;)
    {
      c();
      this.i = true;
      this.f.startScroll(0, 0, 10000, 0, (int)this.g);
      this.e.postDelayed(this.k, 5L);
      this.a.a(false, false);
      return;
      this.f = new Scroller(tn.a(), new AccelerateInterpolator());
      continue;
      this.f = new Scroller(tn.a(), new DecelerateInterpolator());
      continue;
      this.f = new Scroller(tn.a(), new AccelerateDecelerateInterpolator());
    }
  }
  
  protected abstract void a(float paramFloat);
  
  public final void a(sn.a parama)
  {
    this.d = parama;
  }
  
  public final void b()
  {
    if (this.i)
    {
      this.i = false;
      if (this.c != null) {
        this.c.b();
      }
      this.a.h().a(true);
    }
  }
  
  protected abstract void c();
  
  protected abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sn
 * JD-Core Version:    0.7.0.1
 */