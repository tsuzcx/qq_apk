package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class in
  implements View.OnTouchListener
{
  private static final float a;
  private boolean b;
  private boolean c;
  private int d;
  private PointF e;
  private PointF f;
  private PointF g;
  private PointF h;
  private PointF i;
  private PointF j;
  private PointF k;
  private long l;
  private GestureDetector m;
  private io n;
  private hl o;
  private WeakReference<ib> p;
  
  static
  {
    AppMethodBeat.i(148583);
    a = (float)Math.cos(0.001745329278001762D);
    AppMethodBeat.o(148583);
  }
  
  public in(ib paramib)
  {
    AppMethodBeat.i(148573);
    this.e = new PointF();
    this.f = new PointF();
    this.g = new PointF();
    this.h = new PointF();
    this.i = new PointF();
    this.j = new PointF();
    this.k = new PointF();
    this.l = 0L;
    this.p = new WeakReference(paramib);
    if (paramib.i() != null) {}
    for (this.m = new GestureDetector(paramib.i(), new in.a(this, null));; this.m = new GestureDetector(new in.a(this, null)))
    {
      this.n = new io();
      AppMethodBeat.o(148573);
      return;
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(148577);
    float f3 = this.e.x - this.g.x;
    float f1 = this.e.y - this.g.y;
    float f4 = this.f.x - this.h.x;
    float f2 = this.f.y - this.h.y;
    double d1;
    if ((this.d == 0) || (this.d == 1))
    {
      io localio;
      if (this.d == 0)
      {
        d1 = 24.0D;
        if (((Math.abs(f3) <= d1) && (Math.abs(f1) <= d1) && (Math.abs(f4) <= d1) && (Math.abs(f2) <= d1)) || (f1 * f2 <= 0.0F) || (Math.abs(f1) <= Math.abs(f3) * 1.2D) || (Math.abs(f2) <= Math.abs(f4) * 1.2D)) {
          break label288;
        }
        this.d = 1;
        this.g.set(this.e.x, this.e.y);
        this.h.set(this.f.x, this.f.y);
        localio = this.n;
        if (Math.abs(f1) <= Math.abs(f2)) {
          break label281;
        }
      }
      for (;;)
      {
        localio.a(f1);
        AppMethodBeat.o(148577);
        return;
        d1 = 8.0D;
        break;
        label281:
        f1 = f2;
      }
    }
    label288:
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
      label537:
      int i2;
      if (this.d == 0)
      {
        d2 = 5.0D;
        if (Math.abs(d1) <= d2) {
          break label772;
        }
        this.d = 2;
        if (!b()) {
          break label669;
        }
        if (this.o != null) {
          break label631;
        }
        i1 = 0;
        if (this.o != null) {
          break label650;
        }
        i2 = 0;
        label547:
        this.k.set(i1, i2);
        this.n.a(this.k, this.k, (float)d1);
      }
      for (;;)
      {
        this.g.set(this.e.x, this.e.y);
        this.h.set(this.f.x, this.f.y);
        AppMethodBeat.o(148577);
        return;
        d2 = 1.0D;
        break;
        label631:
        i1 = this.o.g().width() / 2;
        break label537;
        label650:
        i2 = this.o.g().height() / 2;
        break label547;
        label669:
        this.i.set((this.g.x + this.h.x) / 2.0F, (this.g.y + this.h.y) / 2.0F);
        this.j.set((this.e.x + this.f.x) / 2.0F, (this.e.y + this.f.y) / 2.0F);
        this.n.a(this.i, this.j, (float)d1);
      }
    }
    label772:
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
        AppMethodBeat.o(148577);
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
        AppMethodBeat.o(148577);
        return;
      }
    }
    AppMethodBeat.o(148577);
  }
  
  private void a(PointF paramPointF1, PointF paramPointF2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148581);
    try
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getX(1);
      float f3 = paramMotionEvent.getY(0);
      float f4 = paramMotionEvent.getY(1);
      paramPointF1.set(f1, f3);
      paramPointF2.set(f2, f4);
      AppMethodBeat.o(148581);
      return;
    }
    catch (Exception paramPointF1)
    {
      AppMethodBeat.o(148581);
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(148579);
    int i1;
    int i2;
    label28:
    float f1;
    if (this.o == null)
    {
      i1 = 0;
      if (this.o != null) {
        break label97;
      }
      i2 = 0;
      if (this.o != null) {
        break label116;
      }
      f1 = 0.0F;
      label37:
      if (this.o != null) {
        break label136;
      }
    }
    for (;;)
    {
      if ((Math.abs(paramFloat1 - i1) >= f1) || (Math.abs(paramFloat2 - i2) >= f2)) {
        break label157;
      }
      AppMethodBeat.o(148579);
      return true;
      i1 = this.o.g().width() / 2;
      break;
      label97:
      i2 = this.o.g().height() / 2;
      break label28;
      label116:
      f1 = this.o.g().width() / 3.0F;
      break label37;
      label136:
      f2 = this.o.g().height() / 3.0F;
    }
    label157:
    AppMethodBeat.o(148579);
    return false;
  }
  
  private boolean b()
  {
    AppMethodBeat.i(148578);
    PointF localPointF = MathUtil.getPoiWith2Line(this.h, this.g, this.f, this.e);
    if (localPointF == null)
    {
      AppMethodBeat.o(148578);
      return false;
    }
    boolean bool = a(localPointF.x, localPointF.y);
    AppMethodBeat.o(148578);
    return bool;
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148580);
    boolean bool = a(paramFloat1, paramFloat2);
    AppMethodBeat.o(148580);
    return bool;
  }
  
  private boolean c()
  {
    double d1 = this.g.x - this.h.x;
    double d2 = this.g.y - this.h.y;
    return d1 * d1 + d2 * d2 > 2500.0D;
  }
  
  public void a(hl paramhl)
  {
    this.o = paramhl;
  }
  
  public void a(id paramid)
  {
    AppMethodBeat.i(148574);
    synchronized (this.n)
    {
      this.n.a(paramid);
      AppMethodBeat.o(148574);
      return;
    }
  }
  
  public void b(id paramid)
  {
    AppMethodBeat.i(148575);
    synchronized (this.n)
    {
      this.n.b(paramid);
      AppMethodBeat.o(148575);
      return;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148576);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if (!this.b) {
        this.m.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(148576);
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
      this.n.c();
      AppMethodBeat.o(148576);
      return true;
      long l1 = System.currentTimeMillis() - this.l;
      if ((this.d == 0) && (l1 > 0L) && (l1 < 200L) && (c())) {
        this.n.b();
      }
      this.n.j(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      if (!this.c)
      {
        this.c = true;
        this.n.d();
        AppMethodBeat.o(148576);
        return true;
        if ((this.b) && (!this.c))
        {
          a(this.e, this.f, paramMotionEvent);
          a();
          AppMethodBeat.o(148576);
          return true;
        }
        this.n.k(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.in
 * JD-Core Version:    0.7.0.1
 */