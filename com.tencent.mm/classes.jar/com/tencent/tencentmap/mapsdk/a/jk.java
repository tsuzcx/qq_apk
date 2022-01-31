package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.map.lib.util.MathUtil;
import java.lang.reflect.Method;

public class jk
  implements View.OnTouchListener
{
  private static final float a = (float)Math.cos(0.001745329278001762D);
  private boolean b;
  private boolean c;
  private int d;
  private PointF e = new PointF();
  private PointF f = new PointF();
  private PointF g = new PointF();
  private PointF h = new PointF();
  private PointF i = new PointF();
  private PointF j = new PointF();
  private PointF k = new PointF();
  private long l = 0L;
  private GestureDetector m;
  private jm n;
  private ik o;
  private Method p;
  private Method q;
  
  public jk(Context paramContext)
  {
    if (paramContext != null) {}
    for (this.m = new GestureDetector(paramContext, new jk.a(this, null));; this.m = new GestureDetector(new jk.a(this, null)))
    {
      this.n = new jm();
      return;
    }
  }
  
  private void a()
  {
    float f3 = this.e.x - this.g.x;
    float f1 = this.e.y - this.g.y;
    float f4 = this.f.x - this.h.x;
    float f2 = this.f.y - this.h.y;
    double d1;
    if ((this.d == 0) || (this.d == 1)) {
      if (this.d == 0)
      {
        d1 = 24.0D;
        if (((Math.abs(f3) <= d1) && (Math.abs(f1) <= d1) && (Math.abs(f4) <= d1) && (Math.abs(f2) <= d1)) || (f1 * f2 <= 0.0F) || (Math.abs(f1) <= Math.abs(f3) * 1.2D) || (Math.abs(f2) <= Math.abs(f4) * 1.2D)) {
          break label278;
        }
        this.d = 1;
        this.g.set(this.e.x, this.e.y);
        this.h.set(this.f.x, this.f.y);
        jm localjm = this.n;
        if (Math.abs(f1) <= Math.abs(f2)) {
          break label271;
        }
        label255:
        localjm.a(f1);
      }
    }
    for (;;)
    {
      return;
      d1 = 8.0D;
      break;
      label271:
      f1 = f2;
      break label255;
      label278:
      double d5 = this.h.x - this.g.x;
      double d6 = this.h.y - this.g.y;
      double d7 = this.f.x - this.e.x;
      double d8 = this.f.y - this.e.y;
      double d3 = Math.sqrt(d5 * d5 + d6 * d6);
      double d4 = Math.sqrt(d7 * d7 + d8 * d8);
      double d2;
      if (((this.d == 0) || (this.d == 2)) && (d3 * d4 > 0.0D) && (Math.abs((d5 * d7 + d6 * d8) / (d3 * d4)) < a))
      {
        d2 = 180.0D * Math.acos((d5 * d7 + d6 * d8) / (d3 * d4)) / 3.141592653589793D;
        d1 = d2;
        if (d5 * d8 - d6 * d7 < 0.0D) {
          d1 = -d2;
        }
        int i1;
        label527:
        int i2;
        if (this.d == 0)
        {
          d2 = 5.0D;
          if (Math.abs(d1) <= d2) {
            break label757;
          }
          this.d = 2;
          if (!b()) {
            break label654;
          }
          if (this.o != null) {
            break label616;
          }
          i1 = 0;
          if (this.o != null) {
            break label635;
          }
          i2 = 0;
          label537:
          this.k.set(i1, i2);
          this.n.a(this.k, this.k, (float)d1);
        }
        for (;;)
        {
          this.g.set(this.e.x, this.e.y);
          this.h.set(this.f.x, this.f.y);
          return;
          d2 = 1.0D;
          break;
          label616:
          i1 = this.o.g().width() / 2;
          break label527;
          label635:
          i2 = this.o.g().height() / 2;
          break label537;
          label654:
          this.i.set((this.g.x + this.h.x) / 2.0F, (this.g.y + this.h.y) / 2.0F);
          this.j.set((this.e.x + this.f.x) / 2.0F, (this.e.y + this.f.y) / 2.0F);
          this.n.a(this.i, this.j, (float)d1);
        }
      }
      label757:
      if (((this.d == 0) || (this.d == 3)) && (d3 > 0.0D))
      {
        d2 = d4 / d3;
        if (this.d == 0) {}
        for (d1 = 0.05D; Math.abs(d2 - 1.0D) > d1; d1 = 0.025D)
        {
          this.d = 3;
          this.i.set((this.g.x + this.h.x) / 2.0F, (this.g.y + this.h.y) / 2.0F);
          this.j.set((this.e.x + this.f.x) / 2.0F, (this.e.y + this.f.y) / 2.0F);
          this.n.a(this.i, this.j, d3, d4);
          this.g.set(this.e.x, this.e.y);
          this.h.set(this.f.x, this.f.y);
          return;
        }
      }
      if ((this.d == 0) || (this.d == 4))
      {
        if (this.d == 0) {}
        for (d1 = 80.0D; (Math.abs(f3) > d1) || (Math.abs(f1) > d1) || (Math.abs(f4) > d1) || (Math.abs(f2) > d1); d1 = 8.0D)
        {
          this.d = 4;
          f3 = (f3 + f4) / 2.0F;
          f1 = (f1 + f2) / 2.0F;
          this.n.d(f3, f1);
          this.g.set(this.e.x, this.e.y);
          this.h.set(this.f.x, this.f.y);
          return;
        }
      }
    }
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.p == null)
      {
        this.p = d();
        this.q = e();
      }
      float f1 = ((Float)this.p.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
      float f2 = ((Float)this.p.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
      float f3 = ((Float)this.q.invoke(paramMotionEvent, new Object[] { Integer.valueOf(0) })).floatValue();
      float f4 = ((Float)this.q.invoke(paramMotionEvent, new Object[] { Integer.valueOf(1) })).floatValue();
      paramPointF1.set(f1, f3);
      paramPointF2.set(f2, f4);
      return;
    }
    catch (Exception paramPointF1) {}
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    boolean bool2 = false;
    int i1;
    int i2;
    label26:
    float f1;
    if (this.o == null)
    {
      i1 = 0;
      if (this.o != null) {
        break label102;
      }
      i2 = 0;
      if (this.o != null) {
        break label121;
      }
      f1 = 0.0F;
      label35:
      if (this.o != null) {
        break label141;
      }
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (Math.abs(paramFloat1 - i1) < f1)
      {
        bool1 = bool2;
        if (Math.abs(paramFloat2 - i2) < f2) {
          bool1 = true;
        }
      }
      return bool1;
      i1 = this.o.g().width() / 2;
      break;
      label102:
      i2 = this.o.g().height() / 2;
      break label26;
      label121:
      f1 = this.o.g().width() / 3.0F;
      break label35;
      label141:
      f2 = this.o.g().height() / 3.0F;
    }
  }
  
  private boolean b()
  {
    PointF localPointF = MathUtil.getPoiWith2Line(this.h, this.g, this.f, this.e);
    if (localPointF == null) {
      return false;
    }
    return a(localPointF.x, localPointF.y);
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return a(paramFloat1, paramFloat2);
  }
  
  private boolean c()
  {
    double d1 = this.g.x - this.h.x;
    double d2 = this.g.y - this.h.y;
    return d1 * d1 + d2 * d2 > 2500.0D;
  }
  
  private Method d()
  {
    return MotionEvent.class.getMethod("getX", new Class[] { Integer.TYPE });
  }
  
  private Method e()
  {
    return MotionEvent.class.getMethod("getY", new Class[] { Integer.TYPE });
  }
  
  public void a(ik paramik)
  {
    this.o = paramik;
  }
  
  public void a(jl paramjl)
  {
    synchronized (this.n)
    {
      this.n.a(paramjl);
      return;
    }
  }
  
  public void b(jl paramjl)
  {
    synchronized (this.n)
    {
      this.n.b(paramjl);
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if (!this.b) {
        this.m.onTouchEvent(paramMotionEvent);
      }
      return true;
      this.l = 0L;
      this.b = false;
      this.n.i(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.l = System.currentTimeMillis();
      this.d = 0;
      this.b = true;
      this.c = false;
      a(this.g, this.h, paramMotionEvent);
      this.n.b();
      return true;
      long l1 = System.currentTimeMillis() - this.l;
      if ((this.d == 0) && (l1 > 0L) && (l1 < 200L) && (c())) {
        this.n.a();
      }
      this.n.j(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      if (!this.c)
      {
        this.c = true;
        this.n.c();
        return true;
        if ((this.b) && (!this.c))
        {
          a(this.e, this.f, paramMotionEvent);
          a();
          return true;
        }
        this.n.k(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jk
 * JD-Core Version:    0.7.0.1
 */